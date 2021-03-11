package com.appnull.commands.managers;

import java.util.List;
import java.util.ArrayList;

import com.appnull.schedule.Schedule;

import com.appnull.commands.CommandHandler;
import com.appnull.commands.impls.KysCommand;
import com.appnull.commands.impls.HelpssCommand;
import com.appnull.commands.impls.AddRoleCommand;
import com.appnull.commands.impls.GetCodesCommand;
import com.appnull.commands.impls.ScheduleCommand;
import com.appnull.commands.impls.RemoveRoleCommand;
import com.appnull.commands.impls.GetScheduleCommand;
import com.appnull.commands.impls.AutoAddRoleCommand;
import com.appnull.commands.impls.AutoRemoveRoleCommand;

import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class CommandManager extends ListenerAdapter {

	protected List<CommandHandler> handlers = new ArrayList<>();

	private static String accessId = "266695705786056704";

	public CommandManager() {

		final Schedule schedule = new Schedule();

		handlers.add(new AddRoleCommand());
		handlers.add(new RemoveRoleCommand());
		handlers.add(new AutoAddRoleCommand());
		handlers.add(new AutoRemoveRoleCommand());
		handlers.add(new KysCommand());

		handlers.add(new ScheduleCommand(schedule));
		handlers.add(new GetScheduleCommand(schedule));
		handlers.add(new HelpssCommand());
		handlers.add(new GetCodesCommand());
	}

	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

		String botId = event.getJDA().getSelfUser().getId();

		if (event.getMember().equals(event.getGuild().getMemberById(botId)))
			return;

		boolean handled = false;

		for (CommandHandler handler : handlers) {

			if (handler.canHandle(event)) {

				handler.handle(event, accessId);
				handled = true;
				break;
			}
		}

		if (!handled)
			event.getMessage().delete().queue();
	}
}
