package io.metaverse.accounts.api;

import com.google.gson.JsonElement;
import io.metaverse.accounts.factory.AccountFactory;
import me.lucko.helper.Services;
import me.lucko.helper.gson.GsonSerializable;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public interface Account extends BaseAccount, GsonSerializable {

    /**
     * Function to create an account
     *
     * @param username - username
     * @param minecraftName - minecraft username
     * @param minecraftUuid {@link UUID} - minecraft uuid
     * @return {@link Account} - account
     */
    static @NotNull Account create(@NotNull String username, @NotNull String minecraftName, @NotNull UUID minecraftUuid) {
        return Services.load(AccountFactory.class).makeAccount(username, minecraftName, minecraftUuid);
    }

    /**
     * Function to create an account
     *
     * {@inheritDoc}
     *
     * @param username - username
     * @param player {@link Player} - player
     * @return {@link Account}- account
     */
    static @NotNull Account create(@NotNull String username, @NotNull Player player) {
        return create(username, player.getName(), player.getUniqueId());
    }

    /**
     * Function to deserialize a {@link JsonElement}
     *
     * {@inheritDoc}
     *
     * @param element - {@link JsonElement}
     * @return {@link Account} - account
     */
    static @NotNull Account deserialize(@NotNull JsonElement element) {
        return Services.load(AccountFactory.class).deserialize(element);
    }

}
