package io.metaverse.accounts.event;

import io.metaverse.accounts.api.Account;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AccountChangeMinecraftNameEvent extends AccountChangeNameEvent {

    public AccountChangeMinecraftNameEvent(@NotNull Player who, @NotNull Account account, @NotNull String oldName) {
        super(who, account, oldName);
    }
}
