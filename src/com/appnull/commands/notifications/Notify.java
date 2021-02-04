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

		eb.setTitle("Известие за час!");
		eb.addField("Предмет: " + subject.getName(),
				"`№ на час:` **" + subject.getPosition() + "**\n**`Код:`** ||**" + subject.getCode() + "**||", true);

		eb.addField("Местоположение: " + subject.getLocation(), "`Начало:` **" + subject.getStartTime()
				+ "**\n`Край:` **" + subject.getEndTime() + "**\n`Следващ час:` **" + subject.getNextTime() + "**",
				true);

		eb.setFooter("Изпратено на " + mantion);
		eb.setColor(Color.RED);
		eb.setThumbnail(imgPNG);

		event.getChannel().sendMessage(mantion).queue();
		event.getChannel().sendMessage(eb.build()).queue();
	}

	public void getCurrentClass() {

		String classD11 = "<@&507287205698600961>";
		String group1 = "<@&711826223742844931>";
		String group2 = "<@&711826277790777424>";

		for (int i = 0; i < subject.getName().length(); i++) {
			if (subject.getName().indexOf('1') != -1)
				messageBase(group1);

			else if (subject.getName().indexOf('2') != -1)
				messageBase(group2);

			else
				messageBase(classD11);
		}
	}

	@Override
	public void run() {
		getCurrentClass();
	}
}
