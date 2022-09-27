package xyz.trixkz.zEnchantments.managers;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import xyz.trixkz.zEnchantments.Main;
import xyz.trixkz.zEnchantments.User;

import java.util.HashMap;
import java.util.Map;

public class UserManager implements Listener {

    private Main main;

    private Map<Player, User> users = new HashMap<Player, User>();

    public UserManager(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        addUser(player);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        users.get(player).save();

        users.remove(player);
    }

    public User getPlayer(Player player) {
        return users.get(player);
    }

    public void save() {
        for (User user : users.values()) {
            user.save();
        }
    }

    public void addUser(Player player) {
        if (!users.containsKey(player)) {
            users.put(player, new User(main, player));
        }
    }
}
