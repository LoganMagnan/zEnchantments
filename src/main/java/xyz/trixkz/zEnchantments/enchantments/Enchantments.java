package xyz.trixkz.zEnchantments.enchantments;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.potion.PotionEffectType;
import xyz.trixkz.zEnchantments.User;
import xyz.trixkz.zEnchantments.utils.Utils;

public enum Enchantments {

    EFFICIENCY(Utils.translate(Utils.EFFICIENCY_ENCHANTMENT), Enchantment.DIG_SPEED, null, false, 1000, 1500, -1, -1, "efficiency"),
    FORTUNE(Utils.translate(Utils.FORTUNE_ENCHANTMENT), Enchantment.LOOT_BONUS_BLOCKS, null, false, 1500, 2000, 5000, 5250, "fortune"),
    UNBREAKING(Utils.translate(Utils.UNBREAKING_ENCHANTMENT), Enchantment.DURABILITY, null, false, 1500, 2000, 5000, 5250, "unbreaking"),
    HASTE(Utils.translate(Utils.HASTE_ENCHANTMENT), null, PotionEffectType.FAST_DIGGING, false, 1500, 2000, 10, 50, "haste"),
    LUCKY_BLOCK_GREED(Utils.translate(Utils.LUCKY_BLOCK_GREED_ENCHANTMENT), null, null, true, 1500, 2000, 1000, 1250, "lucky-block-greed"),
    EXPLOSIVE(Utils.translate(Utils.EXPLOSIVE_ENCHANTMENT), null, null, true, 500, 1500, 500, 750, "explosive"),
    SPEED(Utils.translate(Utils.SPEED_ENCHANTMENT), null, PotionEffectType.SPEED, false, 250, 1000, 5, 25, "speed"),
    JUMP_BOOST(Utils.translate(Utils.JUMP_BOOST_ENCHANTMENT), null, PotionEffectType.JUMP, false, 250, 1000, 5, 25, "jump-boost"),
    // BLESSING(Utils.translate(Utils.BLESSING), null, null, true, 3000, 1500, 50, 500, "blessing"),
    KEY_GREED(Utils.translate(Utils.KEY_GREED_ENCHANTMENT), null, null, true, 3000, 2500, 3000, 3250, "key-greed"),
    TOKEN_GREED(Utils.translate(Utils.TOKEN_GREED_ENCHANTMENT), null, null, true, 3000, 2500, 3000, 3250, "token-greed"),
    JACK_HAMMER(Utils.translate(Utils.JACK_HAMMER_ENCHANTMENT), null, null, true, 3000, 2500, 3000, 3250, "jack-hammer"),
    UNBREAKABLE(Utils.translate(Utils.UNBREAKABLE_ENCHANTMENT), null, null, true, 100000, 3000, 1, 1, "unbreakable"),
    ORB_FINDER(Utils.translate(Utils.ORB_FINDER_ENCHANTMENT), null, null, true, 50000, 5000, 250, 500, "orb-finder");

    private String name;
    private Enchantment enchantment;
    private PotionEffectType potionEffectType;
    private boolean customEnchantment;
    private int price;
    private int levels;
    private int maxLevel;
    private int orbsMaxLevel;
    private String path;

    private Enchantments(String name, Enchantment enchantment, PotionEffectType potionEffectType, boolean customEnchantment, int price, int levels, int maxLevel, int orbsMaxLevel, String path) {
        this.name = name;
        this.enchantment = enchantment;
        this.potionEffectType = potionEffectType;
        this.customEnchantment = customEnchantment;
        this.price = price;
        this.levels = levels;
        this.maxLevel = maxLevel;
        this.orbsMaxLevel = orbsMaxLevel;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public static Enchantments getEnchantment(String name) {
        for (Enchantments enchantments : Enchantments.values()) {
            if (name.equals(enchantments.getName())) {
                return enchantments;
            }
        }

        return null;
    }

    public int getLevelCost() {
        return levels;
    }

    public int getPrice() {
        return price;
    }

    public Enchantment getVanillaEnchantment() {
        return enchantment;
    }

    public PotionEffectType getPotionEffect() {
        return potionEffectType;
    }

    public String getYMLPath() {
        return "Enchantments." + path;
    }

    public boolean isEnchantment() {
        return enchantment != null;
    }

    public boolean isPotionEffect() {
        return potionEffectType != null;
    }

    public boolean isCustomEnchantment() {
        return customEnchantment;
    }

    public boolean isMaxLevel(User user, boolean isLeftClick) {
        return maxLevel != -1 && (user.getEnchantLevel(this) >= maxLevel || user.getEnchantLevel(this) + (isLeftClick ? 1 : 10) > maxLevel);
    }

    public boolean isOrbsMaxLevel(User user) {
        return orbsMaxLevel != -1 && (user.getEnchantLevel(this) >= orbsMaxLevel);
    }

    public int getUserPrice(User user, boolean isLeftClick) {
        int currentLevel = user.getEnchantLevel(this);
        int price = this.getPrice() + (currentLevel + (isLeftClick ? 1 : 10)) * this.getLevelCost();
        return price;
    }
}