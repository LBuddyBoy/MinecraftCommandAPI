package me.lbuddyboy.command;

import me.lbuddyboy.command.object.LCommand;
import me.lbuddyboy.command.utils.ClassUtils;

/**
 * @author LBuddyBoy (lbuddyboy.me)
 * 22/06/2021 / 9:43 AM
 * MinecraftCommandAPI / me.lbuddyboy.command
 */
public class CommandHandler {

	public CommandHandler() {
		ClassUtils.getClassesInPackage(Main.getInstance(), "me.lbuddyboy.command.commands").forEach(clazz -> {
			if (LCommand.class.isAssignableFrom(clazz)) {
				try {
					clazz.newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		});
	}

}
