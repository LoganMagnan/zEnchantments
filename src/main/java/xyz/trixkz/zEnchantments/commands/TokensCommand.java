package xyz.trixkz.zEnchantments.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.trixkz.zEnchantments.Main;
import xyz.trixkz.zEnchantments.utils.Utils;

public class TokensCommand implements CommandExecutor {

	private Main main;

	public TokensCommand(Main main) {
		this.main = main;
	}

	private final String prefix = main.getSettingsConfig().getString("Prefix");

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;

		if (args.length == 0) {
			main.getSettingsConfig().getString("Tokens-Command").replaceAll("(tokens)", String.valueOf(main.getTokens().tokens(player)));
			player.sendMessage(Utils.translate(prefix + String.valueOf(main.getSettingsConfig().getString("Tokens-Command"))));
		} else {
			if (player.hasPermission("prisoncore.command.tokens")) {
				if (args.length != 0) {
					if (args[0].equalsIgnoreCase("help")) {
						player.sendMessage(String.valueOf(main.getSettingsConfig().getStringList("Tokens-Command-Help")));
					}
				}

				if (args[0].equalsIgnoreCase("give")) {
					Player target = main.getServer().getPlayer(args[1]);

					if (target.isOnline()) {
						double deposit_amount = Double.valueOf(args[2]);
						main.getTokens().add(target, deposit_amount);
						main.getSettingsConfig().getString("Tokens-Command-Give-Player").replaceAll("(target)", String.valueOf(target.getName()));
						main.getSettingsConfig().getString("Tokens-Command-Give-Player").replaceAll("(deposit_amount)", String.valueOf(deposit_amount));
						player.sendMessage(Utils.translate(prefix + String.valueOf(main.getSettingsConfig().getString("Tokens-Command-Give-Player"))));
						main.getSettingsConfig().getString("Tokens-Command-Give-Target").replaceAll("(deposit_amount)", String.valueOf(deposit_amount));
						target.sendMessage(Utils.translate(prefix + String.valueOf(main.getSettingsConfig().getString("Tokens-Command-Give-Target"))));
					} else {
						main.getSettingsConfig().getString("Tokens-Command-Target-Is-Not-Online").replaceAll("(target)", String.valueOf(target.getName()));
						player.sendMessage(Utils.translate(prefix + String.valueOf(main.getSettingsConfig().getString("Tokens-Command-Target-Is-Not-Online"))));
					}
				} else if (args[0].equalsIgnoreCase("take")) {
					Player target = main.getServer().getPlayer(args[1]);

					if (target.isOnline()) {
						double withdraw_amount = Double.valueOf(args[2]);
						if (withdraw_amount > main.getTokens().tokens(target)) {
							main.getSettingsConfig().getString("Tokens-Command-Take-No-MoonRocks").replaceAll("(target)", String.valueOf(target.getName()));
							main.getSettingsConfig().getString("Tokens-Command-Take-No-MoonRocks").replaceAll("(tokens)", String.valueOf(main.getTokens().tokens(player)));
							player.sendMessage(Utils.translate(prefix + String.valueOf(main.getSettingsConfig().getString("Tokens-Command-Take-No-Tokens"))));
						} else {
							main.getTokens().remove(target, withdraw_amount);
							main.getSettingsConfig().getString("Tokens-Command-Take-Player").replaceAll("(target)", String.valueOf(target.getName()));
							main.getSettingsConfig().getString("Tokens-Command-Take-Player").replaceAll("(withdraw_amount)", String.valueOf(withdraw_amount));
							player.sendMessage(Utils.translate(prefix + String.valueOf(main.getSettingsConfig().getString("Tokens-Command-Take-Player"))));
							main.getSettingsConfig().getString("Tokens-Command-Take-Target").replaceAll("(withdraw_amount)", String.valueOf(withdraw_amount));
							target.sendMessage(Utils.translate(prefix + String.valueOf(main.getSettingsConfig().getString("Tokens-Command-Take-Target"))));
						}
					} else {
						main.getSettingsConfig().getString("Tokens-Command-Target-Is-Not-Online").replaceAll("(target)", String.valueOf(target.getName()));
						player.sendMessage(Utils.translate(prefix + String.valueOf(main.getSettingsConfig().getString("Tokens-Command-Target-Is-Not-Online"))));
					}
				}

				return true;
			} else {
				player.sendMessage(Utils.translate(prefix + String.valueOf(main.getSettingsConfig().getString("Tokens-Command-No-Permissions"))));
			}
		}

		return true;
	}
}