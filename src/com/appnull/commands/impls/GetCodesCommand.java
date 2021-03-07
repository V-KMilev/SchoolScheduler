package com.appnull.commands.impls;

import java.awt.Color;

import com.appnull.commands.CommandHandler;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class GetCodesCommand implements CommandHandler {

	private static String fild = "https://cdn.discordapp.com/attachments/718871472336273429/806569636169515052/11.png";

	public GetCodesCommand() {

	}

	@Override
	public void handle(GuildMessageReceivedEvent event, String userId) {

		EmbedBuilder eb = new EmbedBuilder();

//		eb.setTitle("CraftCN - Subjects codes");
//		eb.addField("> **" + KA.getShortName() + "**", "**Code: ||" + KA.getCode() + "||**", true);
//		eb.addField("> **" + UPKA1.getShortName() + "**", "**Code: ||" + UPKA1.getCode() + "||**", true);
//		eb.addField("> **" + UPKA2.getShortName() + "**", "**Code: ||" + UPKA2.getCode() + "||**", true);
//		eb.addField("> **" + CS.getShortName() + "**", "**Code: ||" + CS.getCode() + "||**", true);
//		eb.addField("> **" + UPCS1.getShortName() + "**", "**Code: ||" + UPCS1.getCode() + "||**", true);
//		eb.addField("> **" + UPCS2.getShortName() + "**", "**Code: ||" + UPCS2.getCode() + "||**", true);
//		eb.addField("> **" + ZPU.getShortName() + "**", "**Code: ||" + ZPU.getCode() + "||**", true);
//		eb.addField("> **" + UPZPU1.getShortName() + "**", "**Code: ||" + UPZPU1.getCode() + "||**", true);
//		eb.addField("> **" + UPZPU2.getShortName() + "**", "**Code: ||" + UPZPU2.getCode() + "||**", true);
//		eb.addField("> **" + OS.getShortName() + "**", "**Code: ||" + OS.getCode() + "||**", true);
//		eb.addField("> **" + UPOS1.getShortName() + "**", "**Code: ||" + UPOS1.getCode() + "||**", true);
//		eb.addField("> **" + UPOS2.getShortName() + "**", "**Code: ||" + UPOS2.getCode() + "||**", true);
//		eb.addField("> **" + KM.getShortName() + "**", "**Code: ||" + KM.getCode() + "||**", true);
//		eb.addField("> **" + UPKM1.getShortName() + "**", "**Code: ||" + UPKM1.getCode() + "||**", true);
//		eb.addField("> **" + UPKM2.getShortName() + "**", "**Code: ||" + UPKM2.getCode() + "||**", true);
//		eb.addField("> **" + UPUMk1.getShortName() + "**", "**Code: ||" + UPUMk1.getCode() + "||**", true);
//		eb.addField("> **" + UPUMk2.getShortName() + "**", "**Code: ||" + UPUMk2.getCode() + "||**", true);
//		eb.addField("> **" + PROG.getShortName() + "**", "**Code: ||" + PROG.getCode() + "||**", true);
//		eb.addField("> **" + GO.getShortName() + "**", "**Code: ||" + GO.getCode() + "||**", true);
//		eb.addField("> **" + BK.getShortName() + "**", "**Code: ||" + BK.getCode() + "||**", true);
//		eb.addField("> **" + NE.getShortName() + "**", "**Code: ||" + NE.getCode() + "||**", true);
//		eb.addField("> **" + SD.getShortName() + "**", "**Code: ||" + SD.getCode() + "||**", true);
//		eb.addField("> **" + BEL.getShortName() + "**", "**Code: ||" + BEL.getCode() + "||**", true);
//		eb.addField("> **" + MAT.getShortName() + "**", "**Code: ||" + MAT.getCode() + "||**", true);
//		eb.addField("> **" + FVS.getShortName() + "**", "**Code: ||" + FVS.getCode() + "||**", true);
//		eb.addField("> **" + ChEP.getShortName() + "**", "**Code: ||" + ChEP.getCode() + "||**", true);
//		eb.addField("> **" + ChKR.getShortName() + "**", "**Code: ||" + ChKR.getCode() + "||**", true);

		eb.setFooter("! For more help https://github.com/V-KMilev or vilimir.k.milev@gmail.com");

		eb.setColor(Color.RED);
		eb.setThumbnail(fild);

		event.getChannel().sendMessage(eb.build()).queue();
	}

	@Override
	public boolean canHandle(GuildMessageReceivedEvent event) {
		return event.getMessage().getContentRaw().startsWith("!getcodes");
	}

}
