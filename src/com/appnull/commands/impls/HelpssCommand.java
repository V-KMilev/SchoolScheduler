package com.appnull.commands.impls;

import java.awt.Color;

import com.appnull.commands.CommandHandler;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class HelpssCommand implements CommandHandler {

	@Override
	public void handle(GuildMessageReceivedEvent event, String userId) {

		EmbedBuilder eb = new EmbedBuilder();

		eb.setTitle("CraftCN - Help");
		eb.addField("> **!schedule**", "**Create** a program", true);
		eb.addField("> **!getschedule**", "**Print** the program", true);
		eb.addField("> **!getcodes**", "**Print** the codes", true);
		eb.setFooter("! For more help https://github.com/V-KMilev or vilimir.k.milev@gmail.com");

		eb.setColor(Color.RED);
		eb.setThumbnail(
				"https://cdn.discordapp.com/attachments/528269500269723658/809022585114722304/received_673238400293642.jpeg");

		event.getChannel().sendMessage(eb.build()).queue();
	}

	@Override
	public boolean canHandle(GuildMessageReceivedEvent event) {
		return event.getMessage().getContentRaw().startsWith("!helpss");
	}

}
