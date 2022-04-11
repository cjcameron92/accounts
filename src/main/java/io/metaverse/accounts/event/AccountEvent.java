package io.metaverse.accounts.event;

import io.metaverse.accounts.api.Account;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

public class AccountEvent extends PlayerEvent {

    public static final HandlerList handlers = new HandlerList();

    protected final Account account;

    public AccountEvent(@NotNull Player who, @NotNull Account account) {
        super(who);
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override public HandlerList getHandlers() {
        return handlers;
    }
}
