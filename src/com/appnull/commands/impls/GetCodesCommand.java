package com.appnull.commands.impls;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import com.appnull.commands.CommandHandler;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class GetCodesCommand implements CommandHandler {

	private static String fild = "https://cdn.discordapp.com/attachments/718871472336273429/806569636169515052/11.png";

	private final Properties prop = new Properties();
	private final String propFileTime = "time.properties";

	private InputStream inputStream;

	@Override
	public void handle(GuildMessageReceivedEvent event, String userId) {

		EmbedBuilder eb = new EmbedBuilder();

		try {

			inputStream = getClass().getClassLoader().getResourceAsStream(propFileTime);

			if (inputStream != null) {
				prop.load(inputStream);
			} else
				throw new FileNotFoundException("property file '" + inputStream + "' not found in the classpath!");

			eb.setTitle("CraftCN - Subjects codes");
			eb.addField("> **" + prop.getProperty("KA.shortName") + "**",
					"**Code: ||" + prop.getProperty("KA.code") + "||**", true);

			eb.addField("> **" + prop.getProperty("UPKA1.shortName") + "**",
					"**Code: ||" + prop.getProperty("UPKA1.code") + "||**", true);

			eb.addField("> **" + prop.getProperty("UPKA2.shortName") + "**",
					"**Code: ||" + prop.getProperty("UPKA2.code") + "||**", true);

			eb.addField("> **" + prop.getProperty("CS.shortName") + "**",
					"**Code: ||" + prop.getProperty("CS.code") + "||**", true);

			eb.addField("> **" + prop.getProperty("UPCS1.shortName") + "**",
					"**Code: ||" + prop.getProperty("UPCS1.code") + "||**", true);

			eb.addField("> **" + prop.getProperty("UPCS2.shortName") + "**",
					"**Code: ||" + prop.getProperty("UPCS2.code") + "||**", true);

			eb.addField("> **" + prop.getProperty("ZPU.shortName") + "**",
					"**Code: ||" + prop.getProperty("ZPU.code") + "||**", true);

			eb.addField("> **" + prop.getProperty("UPZPU1.shortName") + "**",
					"**Code: ||" + prop.getProperty("UPZPU1.code") + "||**", true);

			eb.addField("> **" + prop.getProperty("UPZPU2.shortName") + "**",
					"**Code: ||" + prop.getProperty("UPZPU2.code") + "||**", true);

			eb.addField("> **" + prop.getProperty("OS.shortName") + "**",
					"**Code: ||" + prop.getProperty("OS.code") + "||**", true);

			eb.addField("> **" + prop.getProperty("UPOS1.shortName") + "**",
					"**Code: ||" + prop.getProperty("UPOS1.code") + "||**", true);

			eb.addField("> **" + prop.getProperty("UPOS2.shortName") + "**",
					"**Code: ||" + prop.getProperty("UPOS2.code") + "||**", true);

			eb.addField("> **" + prop.getProperty("KM.shortName") + "**",
					"**Code: ||" + prop.getProperty("KM.code") + "||**", true);

			eb.addField("> **" + prop.getProperty("UPKM1.shortName") + "**",
					"**Code: ||" + prop.getProperty("UPKM1.code") + "||**", true);

			eb.addField("> **" + prop.getProperty("UPKM2.shortName") + "**",
					"**Code: ||" + prop.getProperty("UPKM2.code") + "||**", true);

			eb.addField("> **" + prop.getProperty("UPUMk1.shortName") + "**",
					"**Code: ||" + prop.getProperty("UPUMk1.code") + "||**", true);

			eb.addField("> **" + prop.getProperty("UPUMk2.shortName") + "**",
					"**Code: ||" + prop.getProperty("UPUMk2.code") + "||**", true);

			eb.addField("> **" + prop.getProperty("PROG.shortName") + "**",
					"**Code: ||" + prop.getProperty("PROG.code") + "||**", true);

			eb.addField("> **" + prop.getProperty("GO.shortName") + "**",
					"**Code: ||" + prop.getProperty("GO.code") + "||**", true);

			eb.addField("> **" + prop.getProperty("BK.shortName") + "**",
					"**Code: ||" + prop.getProperty("BK.code") + "||**", true);

			eb.addField("> **" + prop.getProperty("NE.shortName") + "**",
					"**Code: ||" + prop.getProperty("NE.code") + "||**", true);

			eb.addField("> **" + prop.getProperty("SD.shortName") + "**",
					"**Code: ||" + prop.getProperty("SD.code") + "||**", true);

			eb.addField("> **" + prop.getProperty("BEL.shortName") + "**",
					"**Code: ||" + prop.getProperty("BEL.code") + "||**", true);

			eb.addField("> **" + prop.getProperty("MAT.shortName") + "**",
					"**Code: ||" + prop.getProperty("MAT.code") + "||**", true);

			eb.addField("> **" + prop.getProperty("FVS.shortName") + "**",
					"**Code: ||" + prop.getProperty("FVS.code") + "||**", true);

			eb.addField("> **" + prop.getProperty("ChEP.shortName") + "**",
					"**Code: ||" + prop.getProperty("ChEP.code") + "||**", true);

			eb.addField("> **" + prop.getProperty("ChKR.shortName") + "**",
					"**Code: ||" + prop.getProperty("ChKR.code") + "||**", true);

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}

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
