package com.appnull.commands.impls;

import java.awt.Color;

import com.appnull.commands.CommandHandler;

import com.appnull.commands.notifications.subjects.KA;
import com.appnull.commands.notifications.subjects.CS;
import com.appnull.commands.notifications.subjects.NE;
import com.appnull.commands.notifications.subjects.GO;
import com.appnull.commands.notifications.subjects.SD;
import com.appnull.commands.notifications.subjects.OS;
import com.appnull.commands.notifications.subjects.KM;
import com.appnull.commands.notifications.subjects.BEL;
import com.appnull.commands.notifications.subjects.FVS;
import com.appnull.commands.notifications.subjects.ZPU;
import com.appnull.commands.notifications.subjects.MAT;
import com.appnull.commands.notifications.subjects.PROG;
import com.appnull.commands.notifications.subjects.ChEP;
import com.appnull.commands.notifications.subjects.ChKR;
import com.appnull.commands.notifications.subjects.UPKA1;
import com.appnull.commands.notifications.subjects.UPKA2;
import com.appnull.commands.notifications.subjects.UPCS1;
import com.appnull.commands.notifications.subjects.UPCS2;
import com.appnull.commands.notifications.subjects.UPOS1;
import com.appnull.commands.notifications.subjects.UPOS2;
import com.appnull.commands.notifications.subjects.UPKM1;
import com.appnull.commands.notifications.subjects.UPKM2;
import com.appnull.commands.notifications.subjects.UPZPU1;
import com.appnull.commands.notifications.subjects.UPZPU2;
import com.appnull.commands.notifications.subjects.UPUMk1;
import com.appnull.commands.notifications.subjects.UPUMk2;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class GetCodesCommand implements CommandHandler {

	private final KA KA;
	private final UPKA1 UPKA1;
	private final UPKA2 UPKA2;

	private final CS CS;
	private final UPCS1 UPCS1;
	private final UPCS2 UPCS2;

	private final ZPU ZPU;
	private final UPZPU1 UPZPU1;
	private final UPZPU2 UPZPU2;

	private final OS OS;
	private final UPOS1 UPOS1;
	private final UPOS2 UPOS2;

	private final KM KM;
	private final UPKM1 UPKM1;
	private final UPKM2 UPKM2;

	private final UPUMk1 UPUMk1;
	private final UPUMk2 UPUMk2;

	private final SD SD;
	private final NE NE;
	private final GO GO;
	private final MAT MAT;
	private final BEL BEL;
	private final FVS FVS;
	private final PROG PROG;
	private final ChEP ChEP;
	private final ChKR ChKR;

	public GetCodesCommand() {

		KA = new KA();
		UPKA1 = new UPKA1();
		UPKA2 = new UPKA2();

		CS = new CS();
		UPCS1 = new UPCS1();
		UPCS2 = new UPCS2();

		ZPU = new ZPU();
		UPZPU1 = new UPZPU1();
		UPZPU2 = new UPZPU2();

		OS = new OS();
		UPOS1 = new UPOS1();
		UPOS2 = new UPOS2();

		KM = new KM();
		UPKM1 = new UPKM1();
		UPKM2 = new UPKM2();

		UPUMk1 = new UPUMk1();
		UPUMk2 = new UPUMk2();

		SD = new SD();
		NE = new NE();
		GO = new GO();
		BEL = new BEL();
		MAT = new MAT();
		FVS = new FVS();
		PROG = new PROG();
		ChEP = new ChEP();
		ChKR = new ChKR();
	}

	@Override
	public void handle(GuildMessageReceivedEvent event, String userId) {

		EmbedBuilder eb = new EmbedBuilder();

		eb.setTitle("CraftCN - Subjects codes");
		eb.addField("> **" + KA.getName() + "**", "**Code: ||" + KA.getCode() + "||**", true);
		eb.addField("> **" + UPKA1.getName() + "**", "**Code: ||" + UPKA1.getCode() + "||**", true);
		eb.addField("> **" + UPKA2.getName() + "**", "**Code: ||" + UPKA2.getCode() + "||**", true);
		eb.addField("> **" + CS.getName() + "**", "**Code: ||" + CS.getCode() + "||**", true);
		eb.addField("> **" + UPCS1.getName() + "**", "**Code: ||" + UPCS1.getCode() + "||**", true);
		eb.addField("> **" + UPCS2.getName() + "**", "**Code: ||" + UPCS2.getCode() + "||**", true);
		eb.addField("> **" + ZPU.getName() + "**", "**Code: ||" + ZPU.getCode() + "||**", true);
		eb.addField("> **" + UPZPU1.getName() + "**", "**Code: ||" + UPZPU1.getCode() + "||**", true);
		eb.addField("> **" + UPZPU2.getName() + "**", "**Code: ||" + UPZPU2.getCode() + "||**", true);
		eb.addField("> **" + OS.getName() + "**", "**Code: ||" + OS.getCode() + "||**", true);
		eb.addField("> **" + UPOS1.getName() + "**", "**Code: ||" + UPOS1.getCode() + "||**", true);
		eb.addField("> **" + UPOS2.getName() + "**", "**Code: ||" + UPOS2.getCode() + "||**", true);
		eb.addField("> **" + KM.getName() + "**", "**Code: ||" + KM.getCode() + "||**", true);
		eb.addField("> **" + UPKM1.getName() + "**", "**Code: ||" + UPKM1.getCode() + "||**", true);
		eb.addField("> **" + UPKM2.getName() + "**", "**Code: ||" + UPKM2.getCode() + "||**", true);
		eb.addField("> **" + UPUMk1.getName() + "**", "**Code: ||" + UPUMk1.getCode() + "||**", true);
		eb.addField("> **" + UPUMk2.getName() + "**", "**Code: ||" + UPUMk2.getCode() + "||**", true);
		eb.addField("> **" + PROG.getName() + "**", "**Code: ||" + PROG.getCode() + "||**", true);
		eb.addField("> **" + GO.getName() + "**", "**Code: ||" + GO.getCode() + "||**", true);
		eb.addField("> **" + NE.getName() + "**", "**Code: ||" + NE.getCode() + "||**", true);
		eb.addField("> **" + MAT.getName() + "**", "**Code: ||" + MAT.getCode() + "||**", true);
		eb.addField("> **" + BEL.getName() + "**", "**Code: ||" + BEL.getCode() + "||**", true);
		eb.addField("> **" + ChEP.getName() + "**", "**Code: ||" + ChEP.getCode() + "||**", true);
		eb.addField("> **" + ChKR.getName() + "**", "**Code: ||" + ChKR.getCode() + "||**", true);
		eb.addField("> **" + SD.getName() + "**", "**Code: ||" + SD.getCode() + "||**", true);
		eb.addField("> **" + FVS.getName() + "**", "**Code: ||" + FVS.getCode() + "||**", true);

		eb.setFooter("! For more help https://github.com/V-KMilev or vilimir.k.milev@gmail.com");

		eb.setColor(Color.RED);
		eb.setThumbnail("https://cdn.discordapp.com/attachments/718871472336273429/806569636169515052/11.png");

		event.getChannel().sendMessage(eb.build()).queue();
	}

	@Override
	public boolean canHandle(GuildMessageReceivedEvent event) {
		return event.getMessage().getContentRaw().startsWith("!getcodes");
	}

}
