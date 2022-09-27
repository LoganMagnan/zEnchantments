package xyz.trixkz.zEnchantments.utils;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import xyz.trixkz.zEnchantments.Main;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    private Main main;

    public FileUtils(Main main) {
        this.main = main;
    }

    public FileConfiguration loadUser(Player player) {
        File hookDataf = new File(main.getDataFolder() + File.separator + "Players" + File.separator + player.getUniqueId() + ".yml");
        Bukkit.getLogger().severe("--<[ Path: " + hookDataf.getAbsolutePath());
        Bukkit.getLogger().severe("--<[ Exists?: " + hookDataf.exists());
        if (!hookDataf.exists()) {
            Bukkit.getLogger().severe("--<[ Creating new file: " + hookDataf.getName());
            hookDataf.getParentFile().mkdirs();
            try {
                hookDataf.createNewFile();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

        FileConfiguration hookData = new YamlConfiguration();

        try {
            hookData.load(hookDataf);
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (InvalidConfigurationException exception) {
            exception.printStackTrace();
        }

        return hookData;
    }

    public void saveUser(Player player, FileConfiguration yml) {
        File folder = new File(main.getDataFolder() + File.separator + "Players");
        File file = new File(folder, File.separator + player.getUniqueId() + ".yml");

        try {
            yml.save(file);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}