package com.appnull.commands.impls;

import com.appnull.commands.CommandHandler;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class AutoAddRoleCommand extends RoleCommand implements CommandHandler {

	@Override
	public void handle(GuildMessageReceivedEvent event, String userId) {
		roleMannager.automatical(event, userId, true);
	}

	@Override
	public boolean canHandle(GuildMessageReceivedEvent event) {
		return event.getMessage().getContentRaw().startsWith("!AutoAdd");
	}

}
