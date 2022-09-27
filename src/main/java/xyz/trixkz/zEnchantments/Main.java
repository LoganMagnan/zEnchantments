package xyz.trixkz.zEnchantments;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.trixkz.zEnchantments.commands.OrbsCommand;
import xyz.trixkz.zEnchantments.economy.Tokens;
import xyz.trixkz.zEnchantments.inventory.InventoryListener;
import xyz.trixkz.zEnchantments.inventory.InventoryManager;
import xyz.trixkz.zEnchantments.listeners.MenuListener;
import xyz.trixkz.zEnchantments.managers.CommandManager;
import xyz.trixkz.zEnchantments.managers.UserManager;
import xyz.trixkz.zEnchantments.menusystem.PlayerMenuUtil;
import xyz.trixkz.zEnchantments.utils.FileUtils;
import xyz.trixkz.zEnchantments.utils.Utils;

import java.io.File;
import java.util.HashMap;

public class Main extends JavaPlugin {

    // Main class instance
    public static Main instance;
    // File utilities class instance
    private FileUtils files;
    // Settings file
    private File settingsFile;
    // Settings configuration
    private FileConfiguration settingsConfig;
    // Inventory manager class instance
    public InventoryManager inventoryManager;
    // User manager class instance
    private UserManager userManager;
    // Tokens class instance
    private Tokens tokens;
    // Utilities class instance
    private Utils utils;
    private static final HashMap<Player, PlayerMenuUtil> playerMenuUtilMap = new HashMap<>();

    public void onEnable() {
        instance = this;
        Utils.debug("|--> Loading the 'settings.yml' configuration file");
        setupFiles();
        Utils.debug("|--> Successfully loaded the 'settings.yml' configuration file");
        Utils.debug("|--> Loading values");
        loadValues();
        for (Player players : Bukkit.getOnlinePlayers()) {
            userManager.addUser(players);
        }
        Utils.debug("|--> Loading files");
        files = new FileUtils(this);
        Utils.debug("|--> Successfully loaded the files");
        tokens = new Tokens(this);
        Utils.debug("|--> Initiating managers");
        initiateManagers();
        Utils.debug("|--> Registering events");
        registerEvents();
    }

    public void onDisable() {
        instance = null;
        userManager.save();
    }

    /**
     * Loads all of the values from the "settings.yml" configuration file
     */
    private void loadValues() {
        utils = new Utils(this);
    }

    /**
     * Sets up all of the files
     */
    private void setupFiles() {
        if (!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }

        settingsFile = new File(getDataFolder(), "settings.yml");

        if (!settingsFile.exists()) {
            saveResource("settings.yml", false);
        }

        settingsConfig = YamlConfiguration.loadConfiguration(settingsFile);
    }

    /**
     * Initiates all of the managers
     */
    private void initiateManagers() {
        new CommandManager(this);
        inventoryManager = new InventoryManager(this);
        userManager = new UserManager(this);
    }

    /**
     * Registers all of the events
     */
    private void registerEvents() {
//        getServer().getPluginManager().registerEvents(new PickaxeListener(), this);
//        getServer().getPluginManager().registerEvents(new InventoryListener(this), this);
//        getServer().getPluginManager().registerEvents(new SpeedListener(), this);
//        getServer().getPluginManager().registerEvents(new JumpBoostListener(), this);
//        getServer().getPluginManager().registerEvents(new HasteListener(), this);
//        getServer().getPluginManager().registerEvents(new BlockBreakListener(this), this);
//        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        getServer().getPluginManager().registerEvents(new MenuListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryListener(this), this);
        getServer().getPluginManager().registerEvents(userManager, this);
        getServer().getPluginManager().registerEvents(new OrbsCommand(this), this);
    }

    /**
     * Get the Main class instance
     */
    public static Main getInstance() {
        return instance;
    }

    /**
     * Get the file utilities
     * @return FileUtils
     */
    public FileUtils getFiles() {
        return files;
    }

    /**
     * Get the "settings.yml" configuration file
     * @return File
     */
    public File getSettingsFile() {
        return settingsFile;
    }

    /**
     * Get the "settings.yml" configuration
     * @return Configuration
     */
    public FileConfiguration getSettingsConfig() {
        return settingsConfig;
    }

    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }

    /**
     * Get the user manager
     * @return UserManager
     */
    public UserManager getUserManager() {
        return userManager;
    }

    public Tokens getTokens() {
        return tokens;
    }

    public PlayerMenuUtil getPlayerMenuUtil(Player player) {
        PlayerMenuUtil playerMenuUtil;

        if (playerMenuUtilMap.containsKey(player)) {
            return playerMenuUtilMap.get(player);
        } else {
            playerMenuUtil = new PlayerMenuUtil(player);
            playerMenuUtilMap.put(player, playerMenuUtil);

            return playerMenuUtil;
        }
    }
}
