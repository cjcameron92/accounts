package io.metaverse.accounts.api;

import me.lucko.helper.setting.BooleanSettingMap;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public interface BaseAccount {

    @NotNull String getUsername();

    @NotNull String getMinecraftName();

    @NotNull UUID getMinecraftUuid();

    long getLoginTimestamp();

    @NotNull BooleanSettingMap<AccountSetting> getSettings();

    void setUsername(@NotNull String username);

    void setMinecraftName(@NotNull String minecraftName);

    void setLoginTimestamp(long timestamp);

}
