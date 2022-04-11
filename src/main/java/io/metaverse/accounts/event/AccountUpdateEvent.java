package io.metaverse.accounts.event;

import io.metaverse.accounts.api.Account;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AccountUpdateEvent extends AccountEvent {

    private final Account newAccount;

    public AccountUpdateEvent(@NotNull Player who, @NotNull Account account, @NotNull Account oldAccount) {
        super(who, account);
        this.newAccount = oldAccount;
    }


    public Account getOldAccount() {
        return newAccount;
    }
}
