package com.appnull.commands.permissions;

import java.util.List;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class RoleMannager {

	public RoleMannager() {

	}

	public void handed(GuildMessageReceivedEvent event, String accessMember, boolean isAddition) {

		Guild guild = event.getGuild();

//		String input = event.getMessage().getContentRaw();	
//		String[] message = input.split(" ");

		Role role = guild.getRolesByName("�������", true).get(0);

		if (accessMember.equals(event.getMember().getId())) {

			List<Member> mentionedMembers = event.getMessage().getMentionedMembers();

			for (Member currentMember : mentionedMembers) {
				if (isAddition) {
					guild.addRoleToMember(currentMember, role).queue();
					System.out.println("Added: " + currentMember);
				} else {
					guild.removeRoleFromMember(currentMember, role).queue();
					System.out.println("Removed: " + currentMember);
				}
			}
		}
	}

	public void automatically(GuildMessageReceivedEvent event, String accessMember, boolean isAddition) {

		Guild guild = event.getGuild();

		List<Member> members = guild.getMembers();

		Role role = guild.getRolesByName("�������", true).get(0);

		if (accessMember.equals(event.getMember().getId())) {

			for (Member postitionMember : members) {

				if (isAddition) {
					guild.addRoleToMember(postitionMember, role).queue();
					System.out.println("Added: " + postitionMember);
				} else {
					guild.removeRoleFromMember(postitionMember, role).queue();
					System.out.println("Removed: " + postitionMember);
				}
			}
		}
	}
}