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
		eb.addField("> **йю**", "**йнд: ||hzxzzjo||**", true);
		eb.addField("> **со-йю ЦП.1**", "**йнд: ||vb99omq||**", true);
		eb.addField("> **со-йю ЦП.2**", "**йнд: ||3341wao||**", true);
		eb.addField("> **жя**", "**йнд: ||ew6szka||**", true);
		eb.addField("> **со-яУЕЛ ЦП.1**", "**йнд: ||4vtm2fj||**", true);
		eb.addField("> **со-яУЕЛ ЦП.2**", "**йнд: ||1znwjk1||**", true);
		eb.addField("> **гос**", "**йнд: ||3m9tmd5||**", true);
		eb.addField("> **со-гос ЦП.1**", "**йнд: ||ky2j7rs||**", true);
		eb.addField("> **со-гос ЦП.2**", "**йнд: ||6nstghk||**", true);
		eb.addField("> **ня**", "**йнд: ||6sgsil2||**", true);
		eb.addField("> **со-ня ЦП.1**", "**йнд: ||8oumx66||**", true);
		eb.addField("> **со-ня ЦП.2**", "**йнд: ||6sgsil2||**", true);
		eb.addField("> **йл**", "**йнд: ||gyix9kd||**", true);
		eb.addField("> **со-йл**", "**йнд: ||gyix9kd||**", true);
		eb.addField("> **со-йл**", "**йнд: ||[NULL]||**", true);
		eb.addField("> **со-слЙ**", "**йнд: ||[NULL]||**", true);
		eb.addField("> **со-слЙ**", "**йнд: ||[NULL]||**", true);
		eb.addField("> **оПНЦП**", "**йнд: ||[NULL]||**", true);
		eb.addField("> **люр**", "**йнд: ||fcs8b64||**", true);
		eb.addField("> **вео**", "**йнд: ||vva8xiv||**", true);
		eb.addField("> **аек**", "**йнд: ||b2x1o8k||**", true);
		eb.addField("> **ме**", "**йнд: ||r3g6lg3||**", true);
		eb.addField("> **цн**", "**йнд: ||5doin5h||**", true);
		eb.addField("> **яд**", "**йнд: ||mcsehdp||**", true);
		eb.addField("> **тбя**", "**йнд: ||mcsehdp||**", true);
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
