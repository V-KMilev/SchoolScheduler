package com.appnull.commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public interface CommandHandler {

	void handle(GuildMessageReceivedEvent event, String userId);
	
	boolean canHandle(GuildMessageReceivedEvent event);
}
