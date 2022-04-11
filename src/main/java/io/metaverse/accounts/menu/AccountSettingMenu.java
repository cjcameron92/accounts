package io.metaverse.accounts.menu;

import io.metaverse.accounts.Accounts;
import io.metaverse.accounts.api.AccountSetting;
import io.metaverse.accounts.event.AccountSettingChange;
import me.lucko.helper.item.ItemStackBuilder;
import me.lucko.helper.menu.Gui;
import me.lucko.helper.menu.scheme.MenuPopulator;
import me.lucko.helper.menu.scheme.MenuScheme;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class AccountSettingMenu extends Gui {

    public AccountSettingMenu(Player player) {
        super(player, 1, "&cAccount Settings");
    }

    @Override public void redraw() {
        final MenuScheme scheme = new MenuScheme().mask("111111111");
        final MenuPopulator menuPopulator = scheme.newPopulator(this);

        Accounts.getRegistry().getAccount(getPlayer().getUniqueId()).ifPresent(account -> {
            for (AccountSetting setting : AccountSetting.values()) {
                menuPopulator.acceptIfSpace(ItemStackBuilder.
                        of(setting.getMaterial()).name(setting.getName())
                        .build(() -> {
                            boolean toggled = account.getSettings().toggle(setting);
                            getPlayer().sendMessage(ChatColor.YELLOW + "You've " + setting.getName() + " " + (toggled ? "on" : "off"));
                            Bukkit.getServer().getPluginManager().callEvent(new AccountSettingChange(getPlayer(), account, setting, toggled));
                        }));
            }
        });
    }
}
