package com.appnull.botmain;

import com.appnull.commands.managers.CommandManager;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class NullBot extends ListenerAdapter {
	public static JDA jda;

	public static void main(String[] args) throws Exception {
		String key = "";

		JDA jda = JDABuilder.createDefault(key).build();

		// Locale locale = new Locale("bg", "BG");

		jda.getPresence().setStatus(OnlineStatus.ONLINE);

		try {
			jda.addEventListener(new CommandManager());

		} catch (Exception e) {
			System.out.println("[CraftCN main] Connection Error - CommandManager!");
		}

	}

}
//Code by CN - https://github.com/V-KMilev
