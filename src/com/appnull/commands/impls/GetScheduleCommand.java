package com.appnull.commands.impls;

import com.appnull.commands.CommandHandler;
import com.appnull.schedule.Schedule;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class GetScheduleCommand extends HasAccess implements CommandHandler {

	private final Schedule schedule;

	public GetScheduleCommand(Schedule schedule) {
		this.schedule = schedule;
	}

	@Override
	public void handle(GuildMessageReceivedEvent event, String userId) {

		event.getChannel()
				.sendMessage("**CraftCN | " + "Server: `" + event.getGuild().getName() + "` End-Date: `"
						+ schedule.getEndDate() + "`** **Scheduler: " + event.getMember().getAsMention() + " | `"
						+ schedule.getScheduleStartTime() + "`**")
				.queue();

		for (String task : schedule.getScheduledTasksLog())
			event.getChannel().sendMessage(task).queue();
	}

	@Override
	public boolean canHandle(GuildMessageReceivedEvent event) {
		return hasAccess(event) && event.getMessage().getContentRaw().startsWith("!getschedule");
	}

}
