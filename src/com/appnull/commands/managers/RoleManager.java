package com.appnull.commands.managers;

import java.util.List;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class RoleManager {

	private static List<Member> members;
	private static Role role;

	public void roleSetter(GuildMessageReceivedEvent event, String accessMember, String roleName, boolean isHanded,
			boolean isAddition) {

		Guild guild = event.getGuild();

		for (Role currentRole : guild.getRoles()) {

			if (roleName.equals(currentRole.getName())) {
				role = currentRole;
				break;
			}
		}

		if (accessMember.equals(event.getMember().getId())) {

			if (isHanded)
				members = event.getMessage().getMentionedMembers();
			else
				members = guild.getMembers();

			for (Member currentMember : members) {

				if (isAddition) {

					guild.addRoleToMember(currentMember, role).queue();
					System.out.println("CraftCN Added: " + currentMember);
				} else {

					guild.removeRoleFromMember(currentMember, role).queue();
					System.out.println("CraftCN Removed: " + currentMember);
				}
			}
		}
	}
}
