package com.appnull.commands.impls;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public abstract class HasAccess {

	protected boolean hasAccess(GuildMessageReceivedEvent event) {

		final Member owner = event.getGuild().getMemberById("266695705786056704");
		final Member accessMember = event.getGuild().getMemberById("318688044523716608");

		Member currentMember = event.getMember();
		boolean writeaccess = currentMember.hasPermission(net.dv8tion.jda.api.Permission.MESSAGE_WRITE);

		return writeaccess == true && currentMember.equals(accessMember) || currentMember.equals(owner);
	}
}
