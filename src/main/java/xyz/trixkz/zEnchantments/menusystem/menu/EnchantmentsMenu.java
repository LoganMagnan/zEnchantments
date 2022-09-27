package xyz.trixkz.zEnchantments.menusystem.menu;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import xyz.trixkz.zEnchantments.menusystem.PaginatedMenu;
import xyz.trixkz.zEnchantments.menusystem.PlayerMenuUtil;
import xyz.trixkz.zEnchantments.utils.Utils;

public class EnchantmentsMenu extends PaginatedMenu {

    public EnchantmentsMenu(PlayerMenuUtil playerMenuUtil) {
        super(playerMenuUtil);
    }

    @Override
    public String getMenuName() {
        return Utils.translate("&bPickaxe Enchantments");
    }

    @Override
    public int getSlots() {
        return 54;
    }

    @Override
    public void handleMenu(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getClickedInventory().getTitle().equalsIgnoreCase(Utils.translate("&bPickaxe Enchantments"))) {
            switch (event.getCurrentItem().getType()) {
                case WOOL:
                    break;
                case WOOD_BUTTON:
                    if (page == 0) {
                        player.sendMessage(Utils.translate("&bYou are on the first page"));
                    } else {
                        page--;

                        super.open();
                    }
                    break;
                case STONE_BUTTON:
                    if (!((index + 1) >= checks.size())) {
                        page++;

                        super.open();
                    } else {
                        player.sendMessage(Utils.translate("&bYou are on the last page"));
                    }
                    break;
                case BARRIER:
                    player.closeInventory();

                    break;
            }
        }
    }

    @Override
    public void setMenuItems() {
        addMenuBorder();
    }
}
