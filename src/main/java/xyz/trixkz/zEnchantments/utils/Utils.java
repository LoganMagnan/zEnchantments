package xyz.trixkz.zEnchantments.utils;

import org.bukkit.ChatColor;
import xyz.trixkz.zEnchantments.Main;

public class Utils {

    private Main main;

    public static boolean DEBUG_MESSAGE;
    public static String EFFICIENCY_ENCHANTMENT;
    public static String FORTUNE_ENCHANTMENT;
    public static String UNBREAKING_ENCHANTMENT;
    public static String HASTE_ENCHANTMENT;
    public static String LUCKY_BLOCK_GREED_ENCHANTMENT;
    public static String EXPLOSIVE_ENCHANTMENT;
    public static String SPEED_ENCHANTMENT;
    public static String JUMP_BOOST_ENCHANTMENT;
    // public static String BLESSING_ENCHANTMENT;
    public static String KEY_GREED_ENCHANTMENT;
    public static String TOKEN_GREED_ENCHANTMENT;
    public static String JACK_HAMMER_ENCHANTMENT;
    public static String UNBREAKABLE_ENCHANTMENT;
    public static String ORB_FINDER_ENCHANTMENT;

    public Utils(Main main) {
        this.main = main;

        DEBUG_MESSAGE = main.getSettingsConfig().getBoolean("debug");
        EFFICIENCY_ENCHANTMENT = main.getSettingsConfig().getString("Enchantments.Efficiency.Name");
        FORTUNE_ENCHANTMENT = main.getSettingsConfig().getString("Enchantments.Fortune.Name");
        UNBREAKING_ENCHANTMENT = main.getSettingsConfig().getString("Enchantments.Unbreaking.Name");
        HASTE_ENCHANTMENT = main.getSettingsConfig().getString("Enchantments.Haste.Name");
        LUCKY_BLOCK_GREED_ENCHANTMENT = main.getSettingsConfig().getString("Enchantments.Lucky-Block-Greed.Name");
        EXPLOSIVE_ENCHANTMENT = main.getSettingsConfig().getString("Enchantments.Explosive.Name");
        SPEED_ENCHANTMENT = main.getSettingsConfig().getString("Enchantments.Speed.Name");
        JUMP_BOOST_ENCHANTMENT = main.getSettingsConfig().getString("Enchantments.Jump-Boost.Name");
        // BLESSING_ENCHANTMENT = main.getSettingsConfig().getString("Enchantments.Blessing.Name");
        KEY_GREED_ENCHANTMENT = main.getSettingsConfig().getString("Enchantments.Key-Greed.Name");
        TOKEN_GREED_ENCHANTMENT = main.getSettingsConfig().getString("Enchantments.Token-Greed.Name");
        JACK_HAMMER_ENCHANTMENT = main.getSettingsConfig().getString("Enchantments.Jack-Hammer.Name");
        UNBREAKABLE_ENCHANTMENT = main.getSettingsConfig().getString("Enchantments.Unbreakable.Name");
        ORB_FINDER_ENCHANTMENT = main.getSettingsConfig().getString("Enchantments.Orb-Finder.Name");
    }

    /**
     * Translate the specified message to have the proper color codes inside of it
     * @param message - Gets the message to be translated
     * @return String
     */
    public static String translate(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    /**
     * If the "debug" value inside of the "settings.yml" configuration file is enabled,
     * then it will send a message to the console
     * @param message - Gets the message to be sent to the console
     */
    public static void debug(Object... message) {
        if (DEBUG_MESSAGE) {
            for (Object object : message) {
                System.out.println(String.valueOf(object));
            }
        }
    }
}
