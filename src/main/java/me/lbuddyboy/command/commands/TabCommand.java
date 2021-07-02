package me.lbuddyboy.command.commands;

import me.lbuddyboy.command.object.LCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LBuddyBoy (lbuddyboy.me)
 * 22/06/2021 / 10:04 AM
 * MinecraftCommandAPI / me.lbuddyboy.command.commands
 */
public class TabCommand extends LCommand {
	@Override
	public String name() {
		return "Tab";
	}

	@Override
	public List<String> aliases() {
		return emptyList();
	}

	@Override
	public boolean async() {
		return false;
	}

	@Override
	public void run(CommandSender sender, Command command, String label, String[] args) {
		if (!isPlayer(sender)) {
			sendMsg(sender, getNotConsoleMsg());
			return;
		}

		if (isLess(args, 1)) {
			sendMsg(sender, "&c/" + label + " <player>");
			return;
		}

		if (isMore(args, 1)) {
			sendMsg(sender, "&c/" + label + " <player>");
			return;
		}

		if (isNullPlayer(args[0])) {
			sendMsg(sender, "&cCouldn't detect that player online. Weirdddddd");
			return;
		}
		Player player = returnPlayer(args[0]);

		sendMsg(player, "&aHehe " + sender.getName() + " messaged youuuuu.");
		sendMsg(sender, "&aHehe you messaged " + player.getName() + ".");

		return;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

		List<String> possibleTypes = new ArrayList<>();
		possibleTypes.add("test1");
		possibleTypes.add("test2");
		possibleTypes.add("test3");

		if (isWithinArgs(args, 2)) {
			return possibleTypes;
		}

		if (isWithinArgs(args, 1)) {
			List<String> onlineNames = new ArrayList<>();
			Bukkit.getOnlinePlayers().forEach(p -> onlineNames.add(p.getName()));

			if (!onlineNames.isEmpty()) {
				return onlineNames;
			}
		}

		return emptyList();
	}
}
