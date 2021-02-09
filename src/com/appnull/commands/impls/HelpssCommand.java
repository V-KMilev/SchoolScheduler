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
				"https://cdn.discordapp.com/attachments/710039794884935743/785396990242455613/haah_-_Copy_-_Copy_-_Copy.png");

		event.getChannel().sendMessage(eb.build()).queue();
	}

	@Override
	public boolean canHandle(GuildMessageReceivedEvent event) {
		return event.getMessage().getContentRaw().startsWith("!helpss");
	}

}
