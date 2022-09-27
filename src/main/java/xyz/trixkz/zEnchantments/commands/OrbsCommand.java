package xyz.trixkz.zEnchantments.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.trixkz.zEnchantments.Main;
import xyz.trixkz.zEnchantments.User;
import xyz.trixkz.zEnchantments.enchantments.Enchantments;
import xyz.trixkz.zEnchantments.utils.Utils;

public class OrbsCommand implements CommandExecutor, Listener {

    private Main main;

    private final ItemStack efficiency = new ItemStack(Material.NETHER_STAR);
    private final ItemStack fortune = new ItemStack(Material.NETHER_STAR);
    private final ItemStack unbreaking = new ItemStack(Material.NETHER_STAR);
    private final ItemStack haste = new ItemStack(Material.NETHER_STAR);
    private final ItemStack luckyblockgreed = new ItemStack(Material.NETHER_STAR);
    private final ItemStack explosive = new ItemStack(Material.NETHER_STAR);
    private final ItemStack speed = new ItemStack(Material.NETHER_STAR);
    private final ItemStack jumpboost = new ItemStack(Material.NETHER_STAR);
    private final ItemStack keygreed = new ItemStack(Material.NETHER_STAR);
    private final ItemStack tokengreed = new ItemStack(Material.NETHER_STAR);
    private final ItemStack jackhammer = new ItemStack(Material.NETHER_STAR);
    private final ItemStack unbreakable = new ItemStack(Material.NETHER_STAR);
    private final ItemStack orbfinder = new ItemStack(Material.NETHER_STAR);

    private final ItemMeta efficiencyMeta = efficiency.getItemMeta();
    private final ItemMeta fortuneMeta = fortune.getItemMeta();
    private final ItemMeta unbreakingMeta = unbreaking.getItemMeta();
    private final ItemMeta hasteMeta = unbreaking.getItemMeta();
    private final ItemMeta luckyblockgreedMeta = luckyblockgreed.getItemMeta();
    private final ItemMeta explosiveMeta = explosive.getItemMeta();
    private final ItemMeta speedMeta = speed.getItemMeta();
    private final ItemMeta jumpboostMeta = jumpboost.getItemMeta();
    private final ItemMeta keygreedMeta = keygreed.getItemMeta();
    private final ItemMeta tokengreedMeta = tokengreed.getItemMeta();
    private final ItemMeta jackhammerMeta = jackhammer.getItemMeta();
    private final ItemMeta unbreakableMeta = unbreakable.getItemMeta();
    private final ItemMeta orbfinderMeta = unbreakable.getItemMeta();

    public OrbsCommand(Main main) {
        this.main = main;
    }

    private final String prefix = main.getSettingsConfig().getString("Prefix");

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("prisoncore.command.orbs")) {
            if (args.length != 0) {
                if (args[0].equalsIgnoreCase("help")) {
                    sender.sendMessage(Utils.translate("&8&m-----------------------------------------------------"));
                    sender.sendMessage(Utils.translate("&bOrbs Commands"));
                    sender.sendMessage(Utils.translate("&8&m-----------------------------------------------------"));
                    sender.sendMessage(Utils.translate(" &8* &b/orbs give <player> <type> <amount> &8(&7&oGive the specified orb to the specified player.&8)"));
                    sender.sendMessage(Utils.translate(" &8* &b/orbs types &8(&7&oGet all of the orb types.&8)"));
                    sender.sendMessage(Utils.translate("&8&m-----------------------------------------------------"));
                } else if (args[0].equalsIgnoreCase("give")) {
                    Player target = main.getServer().getPlayer(args[1]);

                    assert target != null;
                    if (target.isOnline()) {
                        switch (args[2]) {
                            case "efficiency":
                                int efficiencyAmount = Integer.parseInt(args[3]);
                                efficiencyMeta.setDisplayName(Utils.translate("&bEfficiency Orb"));
                                List<String> efficiencyLore = new ArrayList<String>();
                                efficiencyLore.add(Utils.translate("&fRight click this orb to claim it."));
                                efficiencyLore.add(Utils.translate("&fAmount: &b" + efficiencyAmount));
                                efficiencyMeta.setLore(efficiencyLore);
                                efficiency.setItemMeta(efficiencyMeta);
                                efficiency.setAmount(efficiencyAmount);
                                target.getInventory().addItem(efficiency);
                                sender.sendMessage(Utils.translate(prefix + "&fYou have given &b" + efficiencyAmount + "x &fefficiency orbs to &b" + target.getName() + "&f."));
                                target.sendMessage(Utils.translate(prefix + "&fYou have been given &b" + efficiencyAmount + "x &fefficiency orbs."));
                                break;
                            case "fortune":
                                int fortuneAmount = Integer.parseInt(args[3]);
                                fortuneMeta.setDisplayName(Utils.translate("&bFortune Orb"));
                                List<String> fortuneLore = new ArrayList<String>();
                                fortuneLore.add(Utils.translate("&fRight click this orb to claim it."));
                                fortuneLore.add(Utils.translate("&fAmount: &b" + fortuneAmount));
                                fortuneMeta.setLore(fortuneLore);
                                fortune.setItemMeta(fortuneMeta);
                                fortune.setAmount(fortuneAmount);
                                target.getInventory().addItem(fortune);
                                sender.sendMessage(Utils.translate(prefix + "&fYou have given &b" + fortuneAmount + "x &ffortune orbs to &b" + target.getName() + "&f."));
                                target.sendMessage(Utils.translate(prefix + "&fYou have been given &b" + fortuneAmount + "x &ffortune orbs."));
                                break;
                            case "unbreaking":
                                int unbreakingAmount = Integer.parseInt(args[3]);
                                unbreakingMeta.setDisplayName(Utils.translate("&bUnbreaking Orb"));
                                List<String> unbreakingLore = new ArrayList<String>();
                                unbreakingLore.add(Utils.translate("&fRight click this orb to claim it."));
                                unbreakingLore.add(Utils.translate("&fAmount: &b" + unbreakingAmount));
                                unbreakingMeta.setLore(unbreakingLore);
                                unbreaking.setItemMeta(fortuneMeta);
                                unbreaking.setAmount(unbreakingAmount);
                                target.getInventory().addItem(unbreaking);
                                sender.sendMessage(Utils.translate(prefix + "&fYou have given &b" + unbreakingAmount + "x &funbreaking orbs to &b" + target.getName() + "&f."));
                                target.sendMessage(Utils.translate(prefix + "&fYou have been given &b" + unbreakingAmount + "x &funbreaking orbs."));
                                break;
                            case "haste":
                                int hasteAmount = Integer.parseInt(args[3]);
                                hasteMeta.setDisplayName(Utils.translate("&bHaste Orb"));
                                List<String> hasteLore = new ArrayList<String>();
                                hasteLore.add(Utils.translate("&fRight click this orb to claim it."));
                                hasteLore.add(Utils.translate("&fAmount: &b" + hasteAmount));
                                hasteMeta.setLore(hasteLore);
                                haste.setItemMeta(hasteMeta);
                                haste.setAmount(hasteAmount);
                                target.getInventory().addItem(haste);
                                sender.sendMessage(Utils.translate(prefix + "&fYou have given &b" + hasteAmount + "x &fhaste orbs to &b" + target.getName() + "&f."));
                                target.sendMessage(Utils.translate(prefix + "&fYou have been given &b" + hasteAmount + "x &fhaste orbs."));
                                break;
                            case "luckyblockgreed":
                                int luckyblockgreedAmount = Integer.parseInt(args[3]);
                                luckyblockgreedMeta.setDisplayName(Utils.translate("&bLucky Block Greed Orb"));
                                List<String> luckyblockgreedLore = new ArrayList<String>();
                                luckyblockgreedLore.add(Utils.translate("&fRight click this orb to claim it."));
                                luckyblockgreedLore.add(Utils.translate("&fAmount: &b" + luckyblockgreedAmount));
                                luckyblockgreedMeta.setLore(luckyblockgreedLore);
                                luckyblockgreed.setItemMeta(luckyblockgreedMeta);
                                luckyblockgreed.setAmount(luckyblockgreedAmount);
                                target.getInventory().addItem(luckyblockgreed);
                                sender.sendMessage(Utils.translate(prefix + "&fYou have given &b" + luckyblockgreedAmount + "x &flucky block greed orbs to &b" + target.getName() + "&f."));
                                target.sendMessage(Utils.translate(prefix + "&fYou have been given &b" + luckyblockgreedAmount + "x &flucky block greed orbs."));
                                break;
                            case "explosive":
                                int explosiveAmount = Integer.parseInt(args[3]);
                                explosiveMeta.setDisplayName(Utils.translate("&bExplosive Orb"));
                                List<String> explosiveLore = new ArrayList<String>();
                                explosiveLore.add(Utils.translate("&fRight click this orb to claim it."));
                                explosiveLore.add(Utils.translate("&fAmount: &b" + explosiveAmount));
                                explosiveMeta.setLore(explosiveLore);
                                explosive.setItemMeta(explosiveMeta);
                                explosive.setAmount(explosiveAmount);
                                target.getInventory().addItem(explosive);
                                sender.sendMessage(Utils.translate(prefix + "&fYou have given &b" + explosiveAmount + "x &fexplosive to &b" + target.getName() + "&f."));
                                target.sendMessage(Utils.translate(prefix + "&fYou have been given &b" + explosiveAmount + "x &fexplosive orbs."));
                                break;
                            case "speed":
                                int speedAmount = Integer.parseInt(args[3]);
                                speedMeta.setDisplayName(Utils.translate("&bSpeed Orb"));
                                List<String> speedLore = new ArrayList<String>();
                                speedLore.add(Utils.translate("&fRight click this orb to claim it."));
                                speedLore.add(Utils.translate("&fAmount: &b" + speedAmount));
                                speedMeta.setLore(speedLore);
                                speed.setItemMeta(speedMeta);
                                speed.setAmount(speedAmount);
                                target.getInventory().addItem(speed);
                                sender.sendMessage(Utils.translate(prefix + "&fYou have given &b" + speedAmount + "x &fspeed to &b" + target.getName() + "&f."));
                                target.sendMessage(Utils.translate(prefix + "&fYou have been given &b" + speedAmount + "x &fspeed orbs."));
                                break;
                            case "jumpboost":
                                int jumpboostAmount = Integer.parseInt(args[3]);
                                jumpboostMeta.setDisplayName(Utils.translate("&bJump Boost Orb"));
                                List<String> jumpboostLore = new ArrayList<String>();
                                jumpboostLore.add(Utils.translate("&fRight click this orb to claim it."));
                                jumpboostLore.add(Utils.translate("&fAmount: &b" + jumpboostAmount));
                                jumpboostMeta.setLore(jumpboostLore);
                                jumpboost.setItemMeta(jumpboostMeta);
                                jumpboost.setAmount(jumpboostAmount);
                                target.getInventory().addItem(jumpboost);
                                sender.sendMessage(Utils.translate(prefix + "&fYou have given &b" + jumpboostAmount + "x &fjump boost to &b" + target.getName() + "&f."));
                                target.sendMessage(Utils.translate(prefix + "&fYou have been given &b" + jumpboostAmount + "x &fjump boost orbs."));
                                break;
                            case "keygreed":
                                int keygreedAmount = Integer.parseInt(args[3]);
                                keygreedMeta.setDisplayName(Utils.translate("&bKey Greed Orb"));
                                List<String> keygreedLore = new ArrayList<String>();
                                keygreedLore.add(Utils.translate("&fRight click this orb to claim it."));
                                keygreedLore.add(Utils.translate("&fAmount: &b" + keygreedAmount));
                                keygreedMeta.setLore(keygreedLore);
                                keygreed.setItemMeta(keygreedMeta);
                                keygreed.setAmount(keygreedAmount);
                                target.getInventory().addItem(keygreed);
                                sender.sendMessage(Utils.translate(prefix + "&fYou have given &b" + keygreedAmount + "x &fkey greed to &b" + target.getName() + "&f."));
                                target.sendMessage(Utils.translate(prefix + "&fYou have been given &b" + keygreedAmount + "x &fkey greed orbs."));
                                break;
                            case "tokengreed":
                                int tokengreedAmount = Integer.parseInt(args[3]);
                                tokengreedMeta.setDisplayName(Utils.translate("&bToken Greed Orb"));
                                List<String> tokengreedLore = new ArrayList<String>();
                                tokengreedLore.add(Utils.translate("&fRight click this orb to claim it."));
                                tokengreedLore.add(Utils.translate("&fAmount: &b" + tokengreedAmount));
                                tokengreedMeta.setLore(tokengreedLore);
                                tokengreed.setItemMeta(tokengreedMeta);
                                tokengreed.setAmount(tokengreedAmount);
                                target.getInventory().addItem(tokengreed);
                                sender.sendMessage(Utils.translate(prefix + "&fYou have given &b" + tokengreedAmount + "x &ftoken greed to &b" + target.getName() + "&f."));
                                target.sendMessage(Utils.translate(prefix + "&fYou have been given &b" + tokengreedAmount + "x &ftoken greed orbs."));
                                break;
                            case "jackhammer":
                                int jackhammerAmount = Integer.parseInt(args[3]);
                                jackhammerMeta.setDisplayName(Utils.translate("&bJack Hammer Orb"));
                                List<String> jackhammerLore = new ArrayList<String>();
                                jackhammerLore.add(Utils.translate("&fRight click this orb to claim it."));
                                jackhammerLore.add(Utils.translate("&fAmount: &b" + jackhammerAmount));
                                jackhammerMeta.setLore(jackhammerLore);
                                jackhammer.setItemMeta(jackhammerMeta);
                                jackhammer.setAmount(jackhammerAmount);
                                target.getInventory().addItem(jackhammer);
                                sender.sendMessage(Utils.translate(prefix + "&fYou have given &b" + jackhammerAmount + "x &fjack hammer to &b" + target.getName() + "&f."));
                                target.sendMessage(Utils.translate(prefix + "&fYou have been given &b" + jackhammerAmount + "x &fjack hammer orbs."));
                                break;
                            case "unbreakable":
                                int unbreakableAmount = Integer.parseInt(args[3]);
                                unbreakableMeta.setDisplayName(Utils.translate("&bUnbreakable Orb"));
                                List<String> unbreakableLore = new ArrayList<String>();
                                unbreakableLore.add(Utils.translate("&fRight click this orb to claim it."));
                                unbreakableLore.add(Utils.translate("&fAmount: &b" + unbreakableAmount));
                                unbreakableMeta.setLore(unbreakableLore);
                                unbreakable.setItemMeta(unbreakableMeta);
                                unbreakable.setAmount(unbreakableAmount);
                                target.getInventory().addItem(unbreakable);
                                sender.sendMessage(Utils.translate(prefix + "&fYou have given &b" + unbreakableAmount + "x &funbreakable to &b" + target.getName() + "&f."));
                                target.sendMessage(Utils.translate(prefix + "&fYou have been given &b" + unbreakableAmount + "x &funbreakable orbs."));
                                break;
                            case "orbfinder":
                                int orbfinderAmount = Integer.parseInt(args[3]);
                                orbfinderMeta.setDisplayName(Utils.translate("&bUnbreakable Orb"));
                                List<String> orbfinderLore = new ArrayList<String>();
                                orbfinderLore.add(Utils.translate("&fRight click this orb to claim it."));
                                orbfinderLore.add(Utils.translate("&fAmount: &b" + orbfinderAmount));
                                orbfinderMeta.setLore(orbfinderLore);
                                orbfinder.setItemMeta(orbfinderMeta);
                                orbfinder.setAmount(orbfinderAmount);
                                target.getInventory().addItem(orbfinder);
                                sender.sendMessage(Utils.translate(prefix + "&fYou have given &b" + orbfinderAmount + "x &forb finder to &b" + target.getName() + "&f."));
                                target.sendMessage(Utils.translate(prefix + "&fYou have been given &b" + orbfinderAmount + "x &forb finder orbs."));
                                break;
                        }
                    } else {
                        sender.sendMessage(Utils.translate(prefix + "&cError: " + target.getName() + " is not currently online."));
                    }
                } else if (args[0].equalsIgnoreCase("types")) {
                    sender.sendMessage(Utils.translate(prefix + "&cTypes: efficiency, fortune, unbreaking, haste, luckyblockgreed, explosive, speed, jumpboost, keygreed, tokengreed, jackhammer, unbreakable, orbfinder"));
                }
            }
        } else {
            sender.sendMessage(Utils.translate(prefix + "&cError: You do not have the sufficient permissions to execute this specific command."));
        }

        return true;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();

        try {
            if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
                int amount = player.getInventory().getItemInHand().getAmount();
                String name = player.getInventory().getItemInHand().getItemMeta().getDisplayName().replace(" Orb", "");
                Enchantments enchantments = Enchantments.getEnchantment(name);
                User user = main.getUserManager().getPlayer(player);
                int currentLevel = user.getEnchantLevel(enchantments);

                if (player.getInventory().getItemInHand().getType() == Material.NETHER_STAR && player.getInventory().getItemInHand().hasItemMeta() && player.getInventory().getItemInHand().getItemMeta().getDisplayName().equals(Utils.translate(name + " Orb"))) {
                    if (enchantments.isOrbsMaxLevel(user)) {
                        player.sendMessage(Utils.translate(prefix + "&fYou already have the maximum orbs level for " + name + "&f."));
                    } else {
                        main.getTokens().add(player, amount);
                        user.setEnchantLevel(enchantments, currentLevel + amount);
                        player.getInventory().getItemInHand().setAmount(-1);
                        player.sendMessage(Utils.translate(prefix + "&fYou have claimed &b" + amount + "x " + name + " &forbs."));
                    }
                }
            }
        } catch (NullPointerException exception) {

        }
    }
}