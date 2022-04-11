package io.metaverse.accounts.api;

import me.lucko.helper.setting.BooleanSetting;
import org.bukkit.Material;

public enum AccountSetting implements BooleanSetting {

    MESSAGE_NOTIFY(Material.FEATHER, "Toggle Messages"),
    SOUND_NOTIFY(Material.JUKEBOX, "Toggle Sounds"),
    FRIEND_NOTIFY(Material.FISHING_ROD, "Toggle Friends");

    private final Material material;
    private final String name;

    AccountSetting(Material material, String name) {
        this.material = material;
        this.name = name;
    }

    public Material getMaterial() {
        return material;
    }

    public String getName() {
        return name;
    }
}
