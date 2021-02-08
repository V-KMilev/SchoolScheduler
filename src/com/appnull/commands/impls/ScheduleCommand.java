package com.appnull.commands.impls;

import java.io.IOException;
import java.text.ParseException;

import com.appnull.commands.CommandHandler;
import com.appnull.commands.schedule.Schedule;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class ScheduleCommand extends HasAccess implements CommandHandler {

	Schedule schedule;

	public ScheduleCommand(Schedule schedule) {
		this.schedule = schedule;
	}

	@Override
	public void handle(GuildMessageReceivedEvent event, String userId) {

		try {
			schedule.scheduleTasks(event);

		} catch (IOException | ParseException e) {
			event.getChannel().sendMessage("Error!").queue();

		}
	}

	@Override
	public boolean canHandle(GuildMessageReceivedEvent event) {
		return hasAccess(event) && event.getMessage().getContentRaw().startsWith("!schedule") ;
	}

}
