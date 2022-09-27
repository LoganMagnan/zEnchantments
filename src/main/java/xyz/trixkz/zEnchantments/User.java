package xyz.trixkz.zEnchantments;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import xyz.trixkz.zEnchantments.enchantments.Enchantments;
import java.util.HashMap;
import java.util.Map;

public class User {

    private Map<Enchantments, Integer> levels = new HashMap<Enchantments, Integer>();

    private double tokensBalance;

    private Main main;

    private Player player;

    public User(Main main, Player player) {
        this.main = main;
        this.player = player;

        FileConfiguration data = main.getFiles().loadUser(player);

        for (Enchantments enchantments : Enchantments.values()) {
            levels.put(enchantments, data.getInt(enchantments.getYMLPath(), 0));
        }

        tokensBalance = data.getInt("Tokens");
    }

    public void save() {
        FileConfiguration data = main.getFiles().loadUser(player);

        for (Map.Entry<Enchantments, Integer> entry : levels.entrySet()) {
            data.set(entry.getKey().getYMLPath(), entry.getValue());
        }

        data.set("Tokens", tokensBalance);

        main.getFiles().saveUser(player, data);
    }

    public void setEnchantLevel(Enchantments enchantments, int level) {
        levels.put(enchantments, level);
    }

    public int getEnchantLevel(Enchantments enchantments) {
        return levels.get(enchantments);
    }

    public void setTokensBalance(double tokens) {
        tokensBalance = tokens;
    }

    public void addTokensBalance(double tokens) {
        tokensBalance += tokens;
    }

    public void removeTokensBalance(double tokens) {
        tokensBalance -= tokens;
        if (tokensBalance <= 0) {
            tokensBalance = 0;
        }
    }

    public double getTokensBalance() {
        return tokensBalance;
    }
}
