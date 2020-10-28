package com.appnull.log;

import java.awt.Color;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class UserIfnfoCommand extends ListenerAdapter {

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

		LocalDateTime LocalTime = LocalDateTime.now();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");


		EmbedBuilder eb = new EmbedBuilder();

		eb.setTitle("Помощ от Божанa");
		eb.addField("Команди за voice channel",
				"За да влеза във voice channel:\n !boj join #1/5\n\n Може да си избереш между 5 фрази.", true);
		eb.addField("Команди за voice channel #", "#1 - text\n #2 - text\n #3 - text\n #4 - text\n #5 - text ", true);
		eb.setFooter("Испратено на @ " + formatter.format(LocalTime), event.getGuild().getIconUrl());

		eb.setColor(Color.red);
		eb.setThumbnail(
				"https://cdn.discordapp.com/attachments/528269500269723658/711269499520942230/IMG_20200516_203054.jpg");

		String[] message = event.getMessage().getContentRaw().split(" ");

		if (message.length == 1 && message[0].equalsIgnoreCase("!boj") && !event.getMember().getUser().isBot()) {
			event.getChannel().sendMessage("Преди да говориш с мен трябва да се научиш как: !boj help").queue();

		}

		if (message[0].equalsIgnoreCase("!boj") && message[1].equalsIgnoreCase("help")
				&& !event.getMember().getUser().isBot()) {

			event.getChannel().sendMessage(eb.build()).queue();
		}

		if (message[0].equalsIgnoreCase("!boj") && !message[1].equalsIgnoreCase("help")
				&& !event.getMember().getUser().isBot()) {
			event.getChannel().sendMessage("Опитай отново: !boj help").queue();
		}
	}

	public void onGuildVoiceJoin(GuildVoiceJoinEvent eventvoice, GuildMessageReceivedEvent eventmess) {

	}
}
