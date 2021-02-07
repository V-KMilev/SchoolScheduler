package com.appnull.commands.impls;

import java.awt.Color;

import com.appnull.commands.CommandHandler;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class GetCodesCommand implements CommandHandler {

	@Override
	public void handle(GuildMessageReceivedEvent event, String userId) {

		EmbedBuilder eb = new EmbedBuilder();

		eb.setTitle("CraftCN - SUBJECT CODE");
		eb.addField("> **��**", "**���: ||hzxzzjo||**", true);
		eb.addField("> **��-�� ��.1**", "**���: ||vb99omq||**", true);
		eb.addField("> **��-�� ��.2**", "**���: ||3341wao||**", true);
		eb.addField("> **��**", "**���: ||ew6szka||**", true);
		eb.addField("> **��-���� ��.1**", "**���: ||4vtm2fj||**", true);
		eb.addField("> **��-���� ��.2**", "**���: ||1znwjk1||**", true);
		eb.addField("> **���**", "**���: ||3m9tmd5||**", true);
		eb.addField("> **��-��� ��.1**", "**���: ||ky2j7rs||**", true);
		eb.addField("> **��-��� ��.2**", "**���: ||6nstghk||**", true);
		eb.addField("> **��**", "**���: ||6sgsil2||**", true);
		eb.addField("> **��-�� ��.1**", "**���: ||8oumx66||**", true);
		eb.addField("> **��-�� ��.2**", "**���: ||6sgsil2||**", true);
		eb.addField("> **��**", "**���: ||gyix9kd||**", true);
		eb.addField("> **��-��**", "**���: ||gyix9kd||**", true);
		eb.addField("> **��-��**", "**���: ||[NULL]||**", true);
		eb.addField("> **��-���**", "**���: ||[NULL]||**", true);
		eb.addField("> **��-���**", "**���: ||[NULL]||**", true);
		eb.addField("> **�����**", "**���: ||[NULL]||**", true);
		eb.addField("> **���**", "**���: ||fcs8b64||**", true);
		eb.addField("> **���**", "**���: ||vva8xiv||**", true);
		eb.addField("> **���**", "**���: ||b2x1o8k||**", true);
		eb.addField("> **��**", "**���: ||r3g6lg3||**", true);
		eb.addField("> **��**", "**���: ||5doin5h||**", true);
		eb.addField("> **��**", "**���: ||mcsehdp||**", true);
		eb.addField("> **���**", "**���: ||mcsehdp||**", true);
		eb.setFooter("! For more help CurrentlyNull#3126 or vilimir.k.milev@gmail.com");

		eb.setColor(Color.RED);
		eb.setThumbnail("https://cdn.discordapp.com/attachments/718871472336273429/806569636169515052/11.png");

		event.getChannel().sendMessage(eb.build()).queue();
	}

	@Override
	public boolean canHandle(GuildMessageReceivedEvent event) {
		return event.getMessage().getContentRaw().startsWith("!getcodes");
	}

}
