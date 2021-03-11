package com.appnull.notifications;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.awt.Color;

import java.util.TimerTask;

import com.appnull.subject.Subject;

public class Notify extends TimerTask {

	private final static String img = "https://cdn.discordapp.com/attachments/718871472336273429/806569636169515052/11.png";
	private final String startTime;

	private GuildMessageReceivedEvent event;
	private Subject subject;

	public Notify(GuildMessageReceivedEvent event, Subject subject, String startTime) {

		this.event = event;
		this.subject = subject;
		this.startTime = startTime;
	}

	private String mantion() {

		if (subject.getName().contains("гр.1"))
			return "<@&711826223742844931>";
		else if (subject.getName().contains("гр.2"))
			return "@&711826277790777424>";
		else
			return "<@&507287205698600961>";
	}

	private void messageBase() {

		EmbedBuilder eb = new EmbedBuilder();

		eb.setTitle("Notification about a subject!");

		eb.addField("Subject: " + subject.getName(), "`Positon of the Subject:` **" + subject.getPosition()
				+ "**\n**`Code:`** ||**" + subject.getCode() + "**||", true);

		eb.addField("Location: " + subject.getLocation(),
				"`Start-Time:` **" + subject.getStartTime() + "**\n`End-Time:` **" + subject.getEndTime() + "**", true);

		eb.setFooter(startTime + " to " + mantion());

		eb.setColor(Color.RED);
		eb.setThumbnail(img);

		event.getChannel().sendMessage(mantion()).queue();
		event.getChannel().sendMessage(eb.build()).queue();
	}

	@Override
	public void run() {
		messageBase();
	}
}
