package com.appnull.events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Filter extends ListenerAdapter {

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
				String[] messageSent = event.getMessage().getContentRaw().split(" ");
				
				for (int i = 0; i < messageSent.length; i++) {
					if(messageSent[i].equalsIgnoreCase("not")) {
						
					} else if (messageSent[i].equalsIgnoreCase("Pepe") || messageSent[i].equalsIgnoreCase("PEPE") ||  messageSent[i].equalsIgnoreCase("pepe")) {
						event.getMessage().delete().queue();
						event.getChannel().sendMessage("not funny").queue();
					}
				}
	}
}
