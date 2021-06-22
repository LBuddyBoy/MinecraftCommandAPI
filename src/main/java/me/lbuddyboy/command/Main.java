package me.lbuddyboy.command;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author LBuddyBoy (lbuddyboy.me)
 * 22/06/2021 / 9:34 AM
 * MinecraftCommandAPI / me.lbuddyboy.command
 */
public class Main extends JavaPlugin {

	@Getter public static Main instance;

	@Override
	public void onEnable() {
		instance = this;

		new CommandHandler();
	}
}
