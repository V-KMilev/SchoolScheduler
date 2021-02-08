package com.appnull.commands.impls;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public abstract class HasAccess {

	protected boolean hasAccess(GuildMessageReceivedEvent event) {

		Member owner = event.getGuild().getMemberById("266695705786056704");
		Member currentMember = event.getMember();
		Member accessMember;

		accessMember = event.getGuild().getMemberById("318688044523716608");

		boolean writeaccess = event.getMember().hasPermission(net.dv8tion.jda.api.Permission.MESSAGE_WRITE);

		if (writeaccess == true || currentMember.equals(owner) || currentMember.equals(accessMember))
			return true;
		else
			return false;
	}
}
