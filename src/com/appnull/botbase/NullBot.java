package com.appnull.botbase;

import com.appnull.commands.ScheduleNotofications;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class NullBot extends ListenerAdapter {
	public static JDA jda;

	public static void main(String[] args) throws Exception {
		String key = "NzEwMDM4NDExNTg2Njk5MzM1.XruozQ.tDe4-dOjwCQt4gFo-zpCrg5zAik";

		JDA jda = JDABuilder.createDefault(key).build();

		jda.getPresence().setStatus(OnlineStatus.ONLINE);

		try {
			jda.addEventListener(new ScheduleNotofications());

		} catch (Exception e) {
			System.out.println("Error!");
		}

	}

}
