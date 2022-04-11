package io.metaverse.accounts.factory;

import com.google.common.base.Preconditions;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.metaverse.accounts.api.Account;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public interface AccountFactory {

    @NotNull Account makeAccount(@NotNull String username, @NotNull String minecraftName, @NotNull UUID minecraftUuid);

    default @NotNull Account deserialize(@NotNull JsonElement element) {
        Preconditions.checkArgument(element.isJsonObject());

        final JsonObject object = element.getAsJsonObject();

        final String username = object.get("username").getAsString();
        final String minecraftName = object.get("minecraftName").getAsString();
        final UUID minecraftUuid = UUID.fromString(object.get("minecraftUuid").getAsString());

        return makeAccount(username, minecraftName, minecraftUuid);
    }
}