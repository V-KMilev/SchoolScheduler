package com.appnull.events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class GetMembers {
	
	private String message;
	
	public GetMembers() {
		
	}
	
	private void getMembersbyId(GuildMessageReceivedEvent event) {
		
		message = event.getMessage().getContentRaw();
		
//		if(message.contentEquals("!MpID")) {
//			event.getGuild().getMemberById(userId)
//			
//		}
	}
}
