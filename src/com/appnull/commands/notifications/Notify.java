package com.appnull.commands.notifications;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.Color;

import java.util.TimerTask;

import com.appnull.commands.notifications.base.Subject;

public class Notify extends TimerTask {

	private GuildMessageReceivedEvent event;
	private Subject subject;

	public Notify(GuildMessageReceivedEvent event, Subject subject) {

		this.event = event;
		this.subject = subject;
	}

	public void messageBase(String mantion) {

		String imgPNG = "https://cdn.discordapp.com/attachments/718871472336273429/806569636169515052/11.png";

		EmbedBuilder eb = new EmbedBuilder();

		eb.setTitle("Notification about a subject!");
		eb.addField("Subject: " + subject.getName(),
				"`Positon of the Subject:` **" + subject.getPosition() + "**\n**`Code:`** ||**" + subject.getCode() + "**||", true);

		eb.addField("Location: " + subject.getLocation(), "`Start-Time:` **" + subject.getStartTime()
				+ "**\n`End-Time:` **" + subject.getEndTime() + "**\n`Next subject:` **" + subject.getNextTime() + "**",
				true);

		eb.setFooter("Sent to " + mantion);
		eb.setColor(Color.RED);
		eb.setThumbnail(imgPNG);

		event.getChannel().sendMessage(mantion).queue();
		event.getChannel().sendMessage(eb.build()).queue();
	}

	public void getCurrentSubject() {

		String groupD11 = "<@&507287205698600961>";
		String groupNo1 = "<@&711826223742844931>";
		String groupNo2 = "<@&711826277790777424>";

		for (int i = 0; i < subject.getName().length(); i++) {

			if (subject.getName().indexOf('1') != -1)
				messageBase(groupNo1);

			else if (subject.getName().indexOf('2') != -1)
				messageBase(groupNo2);

			else
				messageBase(groupD11);
		}
	}

	@Override
	public void run() {
		getCurrentSubject();
	}
}
