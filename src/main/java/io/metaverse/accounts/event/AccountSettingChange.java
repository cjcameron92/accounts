package io.metaverse.accounts.event;

import io.metaverse.accounts.api.Account;
import io.metaverse.accounts.api.AccountSetting;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AccountSettingChange extends AccountEvent {

    private final AccountSetting setting;
    private final boolean toggled;

    public AccountSettingChange(@NotNull Player who, @NotNull Account account, AccountSetting setting, boolean toggled) {
        super(who, account);
        this.setting = setting;
        this.toggled = toggled;
    }

    public AccountSetting getSetting() {
        return setting;
    }

    public boolean isToggled() {
        return toggled;
    }
}
