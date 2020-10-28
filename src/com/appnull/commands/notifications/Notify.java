package com.appnull.commands.notifications;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import java.awt.Color;

import java.util.TimerTask;

public class Notify extends TimerTask {

	private GuildMessageReceivedEvent event;
	private Subject subject;

	public Notify(GuildMessageReceivedEvent event, Subject subject) {
		this.event = event;
		this.subject = subject;
	}

	@Override
	public void run() {
		String d10 = "<@&507287205698600961>";
		
		EmbedBuilder eb = new EmbedBuilder();

		eb.setTitle("Известие за час!");
		eb.addField("Имате " + subject.getName() + " в " + subject.getLocation() + "!",
				"Почвате в " + subject.getStartTime() + "..", true);
		eb.setFooter("Изпратено на @11д");

		eb.setColor(Color.BLACK);
		eb.setThumbnail("https://bit.ly/2X7wIEA");

		event.getChannel().sendMessage(d10).queue();
		event.getChannel().sendMessage(eb.build()).queue();
		
	}

}
