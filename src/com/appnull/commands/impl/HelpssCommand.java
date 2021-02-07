package com.appnull.commands.impl;

import java.awt.Color;

import com.appnull.commands.CommandHandler;
import com.appnull.commands.permissions.RoleMannager;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class HelpssCommand implements CommandHandler {

	@Override
	public void handle(GuildMessageReceivedEvent event, String userId) {

		EmbedBuilder eb = new EmbedBuilder();

		eb.setTitle("CraftCN - HELP");
		eb.addField("> **!schedule**", "**Създаване** на програмa", true);
		eb.addField("> **!getschedule**", "**Принтиране** на програма", true);
		eb.addField("> **!getcodes**", "Кодове", true);
		eb.addField("> **!kys**", "kys?", true);
		eb.setFooter("! For more help CurrentlyNull#3126 or vilimir.k.milev@gmail.com");

		eb.setColor(Color.RED);
		eb.setThumbnail(
				"https://cdn.discordapp.com/attachments/710039794884935743/785396990242455613/haah_-_Copy_-_Copy_-_Copy.png");

		event.getChannel().sendMessage(eb.build()).queue();
	}

	@Override
	public boolean canHandle(GuildMessageReceivedEvent event) {
		return event.getMessage().getContentRaw().startsWith("!helpss") && hasMessageRights(event);
	}

	private boolean hasMessageRights(GuildMessageReceivedEvent event) {
		String message = event.getMessage().getContentRaw();

		Member currentMember = event.getMember();
		Member bot = event.getGuild().getMemberById("710038411586699335");

		if (message.contentEquals("!helpss") || message.contentEquals("!getcodes") || message.contentEquals("!kys")
				|| message.contentEquals("!KYS") || message.contentEquals("!schedule")
				|| message.contentEquals("!getschedule") || message.contentEquals("!report") || message.contains("!add")
				|| message.contains("!remove") || message.contains("!Allah") || message.contains("!NoAllah")
				|| currentMember.equals(bot)) {

			return true;

		} else {
			return false;

			;
		}
	}

}
