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

	@Override
	public void run() {

		String classD11 = "<@&507287205698600961>";
		String group1 = "<@&711826223742844931>";
		String group2 = "<@&711826277790777424>";

		String imgPNG = "https://cdn.discordapp.com/attachments/528269500269723658/772904455548305428/programa_11d.PNG";

		boolean getClassD11 = false;
		boolean getGroup1 = false;
		boolean getGroup2 = false;

		for (int i = 0; i < subject.getName().length(); i++) {

			if (subject.getName().indexOf('1') != -1)
				getGroup1 = true;
			else if (subject.getName().indexOf('2') != -1)
				getGroup2 = true;
			else
				getClassD11 = true;
		}

		if (getClassD11) {

			EmbedBuilder eb = new EmbedBuilder();

			eb.setTitle("Известие за час!");
			eb.addField("Предмет: " + subject.getName(),
					"`№ на час:` **" + subject.getPosition() + "**\n**`Код:`** ||**" + subject.getCode() + "**||",
					true);

			eb.addField("Местоположение: " + subject.getLocation(), "`Начало:` **" + subject.getStartTime()
					+ "**\n`Край:` **" + subject.getEndTime() + "**\n`Следващ час:` **" + subject.getNextTime() + "**",
					true);

			eb.setFooter("Изпратено на @11Д");

			eb.setColor(Color.RED);
			eb.setThumbnail(imgPNG);

			event.getChannel().sendMessage(classD11).queue();
			event.getChannel().sendMessage(eb.build()).queue();
		}

		if (getGroup1) {

			EmbedBuilder eb = new EmbedBuilder();

			eb.setTitle("Известие за час!");
			eb.addField("Предмет: " + subject.getName(),
					"`№ на час:` **" + subject.getPosition() + "**\n**`Код:`** ||**" + subject.getCode() + "**||",
					true);

			eb.addField("Местоположение: " + subject.getLocation(), "`Начало:` **" + subject.getStartTime()
					+ "**\n`Край:` **" + subject.getEndTime() + "**\n`Следващ час:` **" + subject.getNextTime() + "**",
					true);

			eb.setFooter("Изпратено на @1ва група");

			eb.setColor(Color.RED);
			eb.setThumbnail(imgPNG);

			event.getChannel().sendMessage(group1).queue();
			event.getChannel().sendMessage(eb.build()).queue();
		}

		if (getGroup2) {

			EmbedBuilder eb = new EmbedBuilder();

			eb.setTitle("Известие за час!");
			eb.addField("Предмет: " + subject.getName(),
					"`№ на час:` **" + subject.getPosition() + "**\n**`Код:`** ||**" + subject.getCode() + "**||",
					true);

			eb.addField("Местоположение: " + subject.getLocation(), "`Начало:` **" + subject.getStartTime()
					+ "**\n`Край:` **" + subject.getEndTime() + "**\n`Следващ час:` **" + subject.getNextTime() + "**",
					true);

			eb.setFooter("Изпратено на @2ра група");

			eb.setColor(Color.RED);
			eb.setThumbnail(imgPNG);

			event.getChannel().sendMessage(group2).queue();
			event.getChannel().sendMessage(eb.build()).queue();
		}
	}

}
