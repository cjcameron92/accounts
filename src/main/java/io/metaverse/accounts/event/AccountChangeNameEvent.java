package io.metaverse.accounts.event;

import io.metaverse.accounts.api.Account;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AccountChangeNameEvent extends AccountEvent {

    private final String oldName;

    public AccountChangeNameEvent(@NotNull Player who, @NotNull Account account, @NotNull String oldName) {
        super(who, account);
        this.oldName = oldName;
    }

    public String getOldName() {
        return oldName;
    }
}
