package io.metaverse.accounts.factory;

import com.google.gson.JsonElement;
import io.metaverse.accounts.api.Account;
import io.metaverse.accounts.api.AccountSetting;
import me.lucko.helper.gson.JsonBuilder;
import me.lucko.helper.setting.BooleanSettingMap;
import me.lucko.helper.setting.BooleanSettingMapFactory;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class SimpleAccountFactory implements AccountFactory {

    @Override public @NotNull Account makeAccount(@NotNull String username, @NotNull String minecraftName, @NotNull UUID minecraftUuid) {
        return new SimpleAccount(username, minecraftName, minecraftUuid);
    }

    private static final class SimpleAccount implements Account {

        private String username, minecraftName;
        private final UUID minecraftUuid;
        private long loginTimestamp;
        private final BooleanSettingMap<AccountSetting> settings;

        public SimpleAccount(String username, String minecraftName, UUID minecraftUuid) {
            this.username = username;
            this.minecraftName = minecraftName;
            this.minecraftUuid = minecraftUuid;
            this.loginTimestamp = System.currentTimeMillis();
            this.settings = BooleanSettingMapFactory.create(AccountSetting.class).newMap();
        }

        @NotNull @Override public JsonElement serialize() {
            return JsonBuilder.object()
                    .add("username", username)
                    .add("minecraftName", minecraftName)
                    .add("minecraftUuid", minecraftUuid.toString())
                    .build();
        }

        @Override public void setUsername(@NotNull String username) {
            this.username = username;
        }

        @Override public void setMinecraftName(@NotNull String minecraftName) {
            this.minecraftName = minecraftName;
        }

        @Override public void setLoginTimestamp(long loginTimestamp) {
            this.loginTimestamp = loginTimestamp;
        }

        @NotNull @Override public String getUsername() {
            return username;
        }

        @NotNull @Override public String getMinecraftName() {
            return minecraftName;
        }

        @NotNull @Override public UUID getMinecraftUuid() {
            return minecraftUuid;
        }

        @Override public long getLoginTimestamp() {
            return loginTimestamp;
        }

        @NotNull @Override public BooleanSettingMap<AccountSetting> getSettings() {
            return settings;
        }

        @Override public String toString() {
            return "SimpleAccount{" +
                    "username='" + username + '\'' +
                    ", minecraftName='" + minecraftName + '\'' +
                    ", minecraftUuid=" + minecraftUuid +
                    ", loginTimestamp=" + loginTimestamp +
                    ", settings=" + settings +
                    '}';
        }
    }
}
