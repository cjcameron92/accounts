package io.metaverse.accounts.event;

import io.metaverse.accounts.api.Account;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AccountCreateEvent extends AccountEvent {

    public AccountCreateEvent(@NotNull Player who, @NotNull Account account) {
        super(who, account);
    }

    public long getTimestamp() {
        return account.getLoginTimestamp();
    }
}
