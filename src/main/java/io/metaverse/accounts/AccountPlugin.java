package io.metaverse.accounts;

import io.metaverse.accounts.api.Account;
import io.metaverse.accounts.event.AccountCreateEvent;
import io.metaverse.accounts.event.AccountEvent;
import io.metaverse.accounts.factory.AccountFactory;
import io.metaverse.accounts.factory.SimpleAccountFactory;
import io.metaverse.accounts.menu.AccountSettingMenu;
import me.lucko.helper.Commands;
import me.lucko.helper.Events;
import me.lucko.helper.Services;
import me.lucko.helper.messaging.Channel;
import me.lucko.helper.plugin.ExtendedJavaPlugin;
import me.lucko.helper.redis.Redis;
import me.lucko.helper.terminable.TerminableConsumer;
import me.lucko.helper.terminable.module.TerminableModule;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.UUID;

public class AccountPlugin extends ExtendedJavaPlugin implements TerminableModule {

    @Override protected void enable() {
        provideService(AccountFactory.class, new SimpleAccountFactory());
        bindModule(this);
    }

    @Override protected void disable() {

    }

    @Override public void setup(@NotNull TerminableConsumer consumer) {
        final Redis redis = Services.load(Redis.class);
        String ACCOUNT_REGISTRY = "accounts";
        final Channel<Account> accountChannel = redis.getChannel(ACCOUNT_REGISTRY, Account.class);

        accountChannel.newAgent((agent, message) -> {
            Accounts.getRegistry().register(message.getMinecraftUuid(), message);
            System.out.println(message.toString());

        }).bindWith(consumer);

        Commands.create().assertPlayer().handler(context -> new AccountSettingMenu(context.sender()).open()).registerAndBind(consumer, "setting", "settings");

        Events.subscribe(AsyncPlayerPreLoginEvent.class).handler(event -> {
            final UUID uuid = event.getUniqueId();
            final String name = event.getName();

            // get account
            final Optional<Account> accountOptional = Accounts.getRegistry().getAccount(uuid);
            final Account account = accountOptional.orElseGet(() -> Account.create(name, name, uuid));
            account.setLoginTimestamp(System.currentTimeMillis());
            account.setMinecraftName(name);

            // publish account to redis
            accountChannel.sendMessage(account).bindWith(consumer);
        }).bindWith(consumer);
    }
}
