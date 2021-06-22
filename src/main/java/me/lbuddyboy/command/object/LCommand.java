package me.lbuddyboy.command.object;

import lombok.Getter;
import me.lbuddyboy.command.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

/**
 * @author LBuddyBoy (lbuddyboy.me)
 * 22/06/2021 / 9:34 AM
 * MinecraftCommandAPI / me.lbuddyboy.command
 */
public abstract class LCommand implements CommandExecutor, TabCompleter {

	@Getter
	public final String permHolder = "commandapi.";
	@Getter
	public final String noPermMsg = "&cNo permission.";
	@Getter
	public final String notConsoleMsg = "&cBad console.";

	public abstract String name();

	public abstract List<String> aliases();

	public LCommand() {
		PluginCommand command = Main.getInstance().getCommand(name());
		command.setAliases(aliases());
		command.setExecutor(this);
	}

	/*
	  Make it a little easier to return a player!
	 */
	public Player returnPlayer(String arg) {
		return Bukkit.getPlayer(arg);
	}

	/*
	  Make it a little simpler and condensed to check if a player has a certain permission.
	 */
	public boolean hasPermission(CommandSender sender) {
		return sender.hasPermission(getPermHolder() + name());
	}

	/*
	  Make it easier to check for anyone who isn't a player (Is it just me who hates typing !(sender instanceOf Player)?)
	 */
	public boolean isPlayer(CommandSender sender) {
		return !(sender instanceof Player);
	}

	/*
	  Check if an array of strings is within the index of whatever argument you want.
	 */
	public boolean isWithinArgs(String[] args, int index) {
		return args.length == index;
	}

	/*
	  Check if a certain string contains a sequence of a character/string.
	 */
	public boolean containsChar(String msg, String sequence) {
		return msg.contains(sequence);
	}

	/*
	  Check if a certain string contains a sequence of characters/strings.
	 */
	public boolean containsChar(String msg, List<String> sequence) {
		for (String s : sequence) {
			if (msg.contains(s)) {
				return true;
			}
		}
		return false;
	}

	/*
	  Quick util for looking if a string has an actual player.
	 */
	public boolean isNullPlayer(String arg) {
		return Bukkit.getPlayer(arg) == null;
	}

	/*
	  Make it easier to just send a message to someone that is also colored :D
	 */
	public void sendMsg(CommandSender sender, String msg) {
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
	}

	/*
	  Make it easier to just send a list of messages to someone that is also colored :D
	 */
	public void sendMsg(CommandSender sender, List<String> msg) {
		msg.forEach(s -> sender.sendMessage(ChatColor.translateAlternateColorCodes('&', s)));
	}

	/*
	  Empty list util just for more condensed code :D
	 */
	public List<String> emptyList() {
		return Collections.emptyList();
	}

}
