package xyz.trixkz.zEnchantments.inventory;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryManager {

	private Inventory pickaxeEnchantments;

	public ItemStack efficiency;
	public ItemStack fortune;
	public ItemStack unbreaking;
	public ItemStack haste;
	public ItemStack luckyblockgreed;
	public ItemStack explosive;
	public ItemStack speed;
	public ItemStack jumpboost;
	// public ItemStack blessing;
	public ItemStack keygreed;
	public ItemStack tokengreed;
	public ItemStack jackhammer;
	public ItemStack unbreakable;
	public ItemStack orbfinder;
	public ItemStack diamondpickaxe;
	public ItemStack getTokens;

	private Main main;

	public InventoryManager(Main main) {
		this.main = main;
	}

	public Inventory getPickaxeInventory(Player player) {
		User user = Main.instance.playersManager.getPlayer(player);
		pickaxeEnchantments = Main.instance.getServer().createInventory(null, 45, CC.translate("&bPickaxe Enchantments"));

		efficiency = new ItemBuilder(Material.GOLD_PICKAXE)
				.setName(CC.translate(main.getFiles().getConfig().getString("Enchantments.Efficiency.Name")))
				.setLore(
						CC.translate(String.valueOf(main.getFiles().getConfig().getStringList("Enchantments.Efficiency.Lore")))
								.replace("(efficiency_level)", String.valueOf(user.getEnchantLevel(Enchantments.EFFICIENCY)))
										.replace("(efficiency_price_left)", String.valueOf(Enchantments.EFFICIENCY.getUserPrice(user, true)))
												.replace("(efficiency_price_right)", String.valueOf(Enchantments.EFFICIENCY.getUserPrice(user, false)))
				).toItemStack();

		fortune = new ItemBuilder(Material.QUARTZ)
				.setName(CC.translate(main.getFiles().getConfig().getString("Enchantments.Fortune.Name")))
				.setLore(
						CC.translate(String.valueOf(main.getFiles().getConfig().getStringList("Enchantments.Fortune.Lore")))
								.replace("(fortune_level)", String.valueOf(user.getEnchantLevel(Enchantments.FORTUNE)))
										.replace("(fortune_price_left)", String.valueOf(Enchantments.FORTUNE.getUserPrice(user, true)))
												.replace("(fortune_price_right)", String.valueOf(Enchantments.FORTUNE.getUserPrice(user, false)))
				).toItemStack();

		unbreaking = new ItemBuilder(Material.ANVIL)
				.setName(CC.translate(main.getFiles().getConfig().getString("Enchantments.Unbreaking.Name")))
				.setLore(
						CC.translate(String.valueOf(main.getFiles().getConfig().getStringList("Enchantments.Unbreaking.Lore")))
								.replace("(unbreaking_level)", String.valueOf(user.getEnchantLevel(Enchantments.UNBREAKING)))
										.replace("(unbreaking_price_left)", String.valueOf(Enchantments.UNBREAKING.getUserPrice(user, true)))
												.replace("(unbreaking_price_right)", String.valueOf(Enchantments.UNBREAKING.getUserPrice(user, false)))
				).toItemStack();

		haste = new ItemBuilder(Material.MINECART)
				.setName(CC.translate(main.getFiles().getConfig().getString("Enchantments.Haste.Name")))
				.setLore(
						CC.translate(String.valueOf(main.getFiles().getConfig().getStringList("Enchantments.Haste.Lore")))
								.replace("(haste_level)", String.valueOf(user.getEnchantLevel(Enchantments.HASTE)))
										.replace("(haste_price_left)", String.valueOf(Enchantments.HASTE.getUserPrice(user, true)))
												.replace("(haste_price_right)", String.valueOf(Enchantments.HASTE.getUserPrice(user, false)))
				).toItemStack();

		luckyblockgreed = new ItemBuilder(Material.SPONGE)
				.setName(CC.translate(main.getFiles().getConfig().getString("Enchantments.Lucky-Block-Greed.Name")))
				.setLore(
						CC.translate(""),
						CC.translate("&fBetter rewards for finding lucky blocks."),
						CC.translate(""),
						CC.translate("&bLeft click &fto add &b+1 &flucky block greed level"),
						CC.translate("&fto your pickaxe."),
						CC.translate(""),
						CC.translate("&bRight click &fto add &b+10 &flucky block greed levels"),
						CC.translate("&fto your pickaxe."),
						CC.translate(""),
						CC.translate("&fLevel: &b" + user.getEnchantLevel(Enchantments.LUCKY_BLOCK_GREED) + " &f/ &b1,000"),
						CC.translate("&fPrice: &b" + Enchantments.LUCKY_BLOCK_GREED.getUserPrice(user, true)),
						CC.translate("&f+10 Levels: &b" + Enchantments.LUCKY_BLOCK_GREED.getUserPrice(user, false))
				).toItemStack();

		explosive = new ItemBuilder(Material.TNT)
				.setName(CC.translate(main.getFiles().getConfig().getString("Enchantments.Explosive.Name")))
				.setLore(
						CC.translate(""),
						CC.translate("&fCreates explosions as you mine."),
						CC.translate(""),
						CC.translate("&bLeft click &fto add &b+1 &fexplosive level"),
						CC.translate("&fto your pickaxe."),
						CC.translate(""),
						CC.translate("&bRight click &fto add &b+10 &fexplosive levels"),
						CC.translate("&fto your pickaxe."),
						CC.translate(""),
						CC.translate("&fLevel: &b" + user.getEnchantLevel(Enchantments.EXPLOSIVE) + " &f/ &b500"),
						CC.translate("&fPrice: &b" + Enchantments.EXPLOSIVE.getUserPrice(user, true)),
						CC.translate("&f+10 Levels: &b" + Enchantments.EXPLOSIVE.getUserPrice(user, false))
				).toItemStack();

		speed = new ItemBuilder(Material.SUGAR)
				.setName(CC.translate(main.getFiles().getConfig().getString("Enchantments.Speed.Name")))
				.setLore(
						CC.translate(""),
						CC.translate("&fFaster movement speed."),
						CC.translate(""),
						CC.translate("&bLeft click &fto add &b+1 &fspeed level"),
						CC.translate("&fto your pickaxe."),
						CC.translate(""),
						CC.translate("&fLevel: &b" + user.getEnchantLevel(Enchantments.SPEED) + " &f/ &b5"),
						CC.translate("&fPrice: &b" + Enchantments.SPEED.getUserPrice(user, true))
				).toItemStack();

		jumpboost = new ItemBuilder(Material.FEATHER)
				.setName(CC.translate(main.getFiles().getConfig().getString("Enchantments.Jump-Boost.Name")))
				.setLore(
						CC.translate(""),
						CC.translate("&fJump higher."),
						CC.translate(""),
						CC.translate("&bLeft click &fto add &b+1 &fjump boost level"),
						CC.translate("&fto your pickaxe."),
						CC.translate(""),
						CC.translate("&fLevel: &b" + user.getEnchantLevel(Enchantments.JUMP_BOOST) + " &f/ &b5"),
						CC.translate("&fPrice: &b" + Enchantments.JUMP_BOOST.getUserPrice(user, true))
				).toItemStack();
		
		/* blessing = new ItemBuilder(Material.FLINT)
				.setName(CC.translate(main.getFiles().getConfig().getString("Enchantments.Blessing.Name")))
				.setLore(
						CC.translate(""),
						CC.translate("&fChance to give all online players tokens."),
						CC.translate(""),
						CC.translate("&bLeft click &fto add &b+1 &fblessing level"),
						CC.translate("&fto your pickaxe."),
						CC.translate(""),
						CC.translate("&bRight click &fto add &b+10 &fblessing levels"),
						CC.translate("&fto your pickaxe."),
						CC.translate(""),
						CC.translate("&fLevel: &b" + user.getEnchantLevel(Enchantments.BLESSING) + " &f/ &b50"),
						CC.translate("&fPrice: &b" + Enchantments.BLESSING.getUserPrice(user, true)),
						CC.translate("&f+10 Levels: &b" + Enchantments.BLESSING.getUserPrice(user, false))
				).toItemStack(); */

		keygreed = new ItemBuilder(Material.TRIPWIRE_HOOK)
				.setName(CC.translate(main.getFiles().getConfig().getString("Enchantments.Key-Greed.Name")))
				.setLore(
						CC.translate(""),
						CC.translate("&fChance to find keys while mining."),
						CC.translate(""),
						CC.translate("&bLeft click &fto add &b+1 &fkey greed level"),
						CC.translate("&fto your pickaxe."),
						CC.translate(""),
						CC.translate("&bRight click &fto add &b+10 &fkey greed levels"),
						CC.translate("&fto your pickaxe."),
						CC.translate(""),
						CC.translate("&fLevel: &b" + user.getEnchantLevel(Enchantments.KEY_GREED) + " &f/ &b3,000"),
						CC.translate("&fPrice: &b" + Enchantments.KEY_GREED.getUserPrice(user, true)),
						CC.translate("&f+10 Levels: &b" + Enchantments.KEY_GREED.getUserPrice(user, false))
				).toItemStack();

		tokengreed = new ItemBuilder(Material.MAGMA_CREAM)
				.setName(CC.translate(main.getFiles().getConfig().getString("Enchantments.Token-Greed.Name")))
				.setLore(
						CC.translate(""),
						CC.translate("&fChance to find tokens while mining."),
						CC.translate(""),
						CC.translate("&bLeft click &fto add &b+1 &ftoken greed level"),
						CC.translate("&fto your pickaxe."),
						CC.translate(""),
						CC.translate("&bRight click &fto add &b+10 &ftoken greed levels"),
						CC.translate("&fto your pickaxe."),
						CC.translate(""),
						CC.translate("&fLevel: &b" + user.getEnchantLevel(Enchantments.TOKEN_GREED) + " &f/ &b3,000"),
						CC.translate("&fPrice: &b" + Enchantments.TOKEN_GREED.getUserPrice(user, true)),
						CC.translate("&f+10 Levels: &b" + Enchantments.TOKEN_GREED.getUserPrice(user, false))
				).toItemStack();

		jackhammer = new ItemBuilder(Material.COMPASS)
				.setName(CC.translate(main.getFiles().getConfig().getString("Enchantments.Jack-Hammer.Name")))
				.setLore(
						CC.translate(""),
						CC.translate("&fChance to wipe one whole row while mining."),
						CC.translate(""),
						CC.translate("&bLeft click &fto add &b+1 &fjack hammer level"),
						CC.translate("&fto your pickaxe."),
						CC.translate(""),
						CC.translate("&bRight click &fto add &b+10 &fjack hammer levels"),
						CC.translate("&fto your pickaxe."),
						CC.translate(""),
						CC.translate("&fLevel: &b" + user.getEnchantLevel(Enchantments.JACK_HAMMER) + " &f/ &b3,000"),
						CC.translate("&fPrice: &b" + Enchantments.JACK_HAMMER.getUserPrice(user, true)),
						CC.translate("&f+10 Levels: &b" + Enchantments.JACK_HAMMER.getUserPrice(user, false))
				).toItemStack();

		unbreakable = new ItemBuilder(Material.FIREWORK)
				.setName(CC.translate(main.getFiles().getConfig().getString("Enchantments.Unbreakable.Name")))
				.setLore(
						CC.translate(""),
						CC.translate("&fUnlimited durability."),
						CC.translate(""),
						CC.translate("&bLeft click &fto add &b+1 &funbreakable level"),
						CC.translate("&fto your pickaxe."),
						CC.translate(""),
						CC.translate("&fLevel: &b" + user.getEnchantLevel(Enchantments.UNBREAKABLE) + " &f/ &b1"),
						CC.translate("&fPrice: &b" + Enchantments.UNBREAKABLE.getUserPrice(user, true))
				).toItemStack();

		orbfinder = new ItemBuilder(Material.NETHER_STAR)
				.setName(CC.translate(main.getFiles().getConfig().getString("Enchantments.Orb-Finder.Name")))
				.setLore(
						CC.translate(""),
						CC.translate("&fFind orbs while mining."),
						CC.translate(""),
						CC.translate("&bLeft click &fto add &b+1 &forb finder level"),
						CC.translate("&fto your pickaxe."),
						CC.translate(""),
						CC.translate("&bRight click &fto add &b+10 &forb finder levels"),
						CC.translate("&fto your pickaxe."),
						CC.translate(""),
						CC.translate("&fLevel: &b" + user.getEnchantLevel(Enchantments.ORB_FINDER) + " &f/ &b250"),
						CC.translate("&fPrice: &b" + Enchantments.ORB_FINDER.getUserPrice(user, true)),
						CC.translate("&f+10 Levels: &b" + Enchantments.ORB_FINDER.getUserPrice(user, false))
				).toItemStack();

		diamondpickaxe = player.getInventory().getItemInHand();

		getTokens = new ItemBuilder(Material.MAGMA_CREAM)
				.setName(CC.translate("&fTokens: &b" + main.getTokens().tokens(player)))
				.toItemStack();

		pickaxeEnchantments.setItem(0, diamondpickaxe);
		pickaxeEnchantments.setItem(8, getTokens);
		pickaxeEnchantments.setItem(11, efficiency);
		pickaxeEnchantments.setItem(12, fortune);
		pickaxeEnchantments.setItem(13, unbreaking);
		pickaxeEnchantments.setItem(14, haste);
		pickaxeEnchantments.setItem(15, luckyblockgreed);
		pickaxeEnchantments.setItem(20, explosive);
		pickaxeEnchantments.setItem(21, speed);
		pickaxeEnchantments.setItem(22, jumpboost);
		// pickaxeEnchantments.setItem(22, blessing);
		pickaxeEnchantments.setItem(23, keygreed);
		pickaxeEnchantments.setItem(24, tokengreed);
		pickaxeEnchantments.setItem(29, jackhammer);
		pickaxeEnchantments.setItem(31, unbreakable);
		pickaxeEnchantments.setItem( 32, orbfinder);

		return pickaxeEnchantments;
	}
}