package me.lbuddyboy.command.commands;

import lombok.Getter;
import me.lbuddyboy.command.object.LCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.List;

/**
 * @author LBuddyBoy (lbuddyboy.me)
 * 22/06/2021 / 9:41 AM
 * MinecraftCommandAPI / me.lbuddyboy.command
 */
public class ExampleCommand extends LCommand {

	@Getter private final List<String> namesOfClients = Arrays.asList("&cBob", "&cLBuddyBoy", "&aJarold");

	@Override
	public String name() {
		return "example";
	}

	@Override
	public List<String> aliases() {
		return Arrays.asList("example1", "example2");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!hasPermission(sender)) {
			sendMsg(sender, getNoPermMsg());
			return true;
		}

		if (!isPlayer(sender)) {
			sendMsg(sender, "&cNot a player dumbo");
			return false;
		}

		if (isWithinArgs(args, 1)) {
			if (containsChar(args[0], "clients")) {
				sendMsg(sender, getNamesOfClients());
				return true;
			}
			if (containsChar(args[0], "literal")) {
				sendMsg(sender, "&aThis is very literal lolololol");
				return true;
			}
			sendMsg(sender, "&aDetected another argument successfully!");
		} else {
			sendMsg(sender, "&c/" + label + " <anything here || literal>");
		}

		return false;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

		return emptyList();
	}
}
