package io.metaverse.accounts.event;

import io.metaverse.accounts.api.Account;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AccountLoginEvent extends AccountEvent {

    public AccountLoginEvent(@NotNull Player who, @NotNull Account account) {
        super(who, account);
    }

    public long getLoginTimestamp() {
        return account.getLoginTimestamp();
    }
}
