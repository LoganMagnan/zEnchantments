package xyz.trixkz.zEnchantments.economy;

import org.bukkit.entity.Player;
import xyz.trixkz.zEnchantments.Main;
import xyz.trixkz.zEnchantments.User;

public class Tokens {

	public Main main;

	public Tokens(Main main) {
		this.main = main;
	}

	public boolean has(Player player, double tokens) {
		User user = main.getUserManager().getPlayer(player);
		return user.getTokensBalance() >= tokens;
	}

	public double tokens(Player player) {
		User user = main.getUserManager().getPlayer(player);
		return user.getTokensBalance();
	}

	public void add(Player player, double tokens) {
		User user = main.getUserManager().getPlayer(player);
		user.addTokensBalance(tokens);
	}

	public void remove(Player player, double tokens) {
		User user = main.getUserManager().getPlayer(player);
		user.removeTokensBalance(tokens);
	}

	public void set(Player player, double tokens) {
		User user = main.getUserManager().getPlayer(player);
		user.setTokensBalance(tokens);
	}
}