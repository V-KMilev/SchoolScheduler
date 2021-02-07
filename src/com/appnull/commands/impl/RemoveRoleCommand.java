package com.appnull.commands.impl;

import com.appnull.commands.CommandHandler;
import com.appnull.commands.permissions.RoleMannager;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class RemoveRoleCommand extends RoleCommand implements CommandHandler {

	@Override
	public void handle(GuildMessageReceivedEvent event, String userId) {
		roleMannager.handed(event, userId, false);
	}

	@Override
	public boolean canHandle(GuildMessageReceivedEvent event) {
		return event.getMessage().getContentRaw().startsWith("!remove");
	}

}
