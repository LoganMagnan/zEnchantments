package xyz.trixkz.zEnchantments.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import xyz.trixkz.zenchantments.Main;
import xyz.trixkz.zenchantments.User;
import xyz.trixkz.zenchantments.enchantments.Enchantments;
import xyz.trixkz.zenchantments.utils.CC;

public class InventoryListener implements Listener {

	private Main main;

	private final String prefix = Main.getInstance().getFiles().getConfig().getString("Prefix");

	public InventoryListener(Main main) {
		this.main = main;
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		Inventory inventory = event.getClickedInventory();
		ItemStack item = event.getCurrentItem();

		if (inventory == null || item == null || item.getType() == Material.AIR) return;

		if (event.getView().getTitle().equalsIgnoreCase(CC.translate("&bPickaxe Enchantments"))) {
			event.setCancelled(true);

			if (!event.getClick().isLeftClick() && !event.getClick().isRightClick()) return;

			Enchantments enchantments = Enchantments.getEnchantment(Objects.requireNonNull(item.getItemMeta()).getDisplayName());

			if (enchantments == null) {
				return;
			}

			User user = main.playersManager.getPlayer(player);

			if (enchantments.isMaxLevel(user, event.getClick().isLeftClick())) {
				player.sendMessage(CC.translate(prefix + "Already maxed out"));
				return;
			}

			int currentLevel = user.getEnchantLevel(enchantments);

			int price = enchantments.getPrice() + (currentLevel + (event.getClick().isLeftClick() ? 1 : 10)) * enchantments.getLevelCost();

			if (main.getTokens().tokens(player) < price) {
				player.sendMessage(CC.translate(prefix + "Not enough tokens"));
				return;
			}

			main.getTokens().remove(player, price);

			user.setEnchantLevel(enchantments, currentLevel + (event.getClick().isLeftClick() ? 1 : 10));

			ItemStack pickaxe = player.getInventory().getItemInHand();
			ItemMeta itemMeta = pickaxe.getItemMeta();
			assert itemMeta != null;
			itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			List<String> lore = itemMeta.hasLore() ? itemMeta.getLore() : new ArrayList<String>();
			boolean found = false;

			for (int index = 0; index < Objects.requireNonNull(lore).size(); index++) {
				if (lore.get(index).split(CC.translate("&7: "))[0].equalsIgnoreCase(enchantments.getName())) {
					lore.remove(index);
					lore.add(index, CC.translate(enchantments.getName() + "&7: " + user.getEnchantLevel(enchantments)));
					found = true;
					break;
				}
			}

			if (!found) {
				lore.add(lore.size() - 1, CC.translate(enchantments.getName() + "&7: " + user.getEnchantLevel(enchantments)));
			}

			itemMeta.setLore(lore);
			pickaxe.setItemMeta(itemMeta);

			if (enchantments.isEnchantment()) {
				pickaxe.addUnsafeEnchantment(enchantments.getVanillaEnchantment(), user.getEnchantLevel(enchantments));
			}

			player.openInventory(main.inventoryManager.getPickaxeInventory(player));
		}
	}
}