package com.appnull.commands;

import java.awt.Color;

import java.io.IOException;

import java.util.Map;
import java.util.List;
import java.util.Date;
import java.util.Timer;
import java.util.Calendar;
import java.util.ArrayList;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.collections4.map.HashedMap;

import com.appnull.commands.impl.AddRoleCommand;
import com.appnull.commands.impl.HelpssCommand;
import com.appnull.commands.impl.RemoveRoleCommand;
import com.appnull.commands.notifications.Notify;
import com.appnull.commands.notifications.base.Subject;
import com.appnull.commands.notifications.base.SubjectImpl;

import com.appnull.commands.notifications.subjects.GO;
import com.appnull.commands.notifications.subjects.KA;
import com.appnull.commands.notifications.subjects.NE;
import com.appnull.commands.notifications.subjects.SD;
import com.appnull.commands.notifications.subjects.BK;
import com.appnull.commands.notifications.subjects.MAT;
import com.appnull.commands.notifications.subjects.BEL;
import com.appnull.commands.notifications.subjects.FVS;
import com.appnull.commands.notifications.subjects.ZPU;
import com.appnull.commands.notifications.subjects.ChEP;
import com.appnull.commands.notifications.subjects.ChKR;
import com.appnull.commands.notifications.subjects.PROG;
import com.appnull.commands.notifications.subjects.UPKA1;
import com.appnull.commands.notifications.subjects.UPKA2;
import com.appnull.commands.notifications.subjects.UPKM1;
import com.appnull.commands.notifications.subjects.UPKM2;
import com.appnull.commands.notifications.subjects.UPOS1;
import com.appnull.commands.notifications.subjects.UPOS2;
import com.appnull.commands.notifications.subjects.UPUMk1;
import com.appnull.commands.notifications.subjects.UPUMk2;
import com.appnull.commands.notifications.subjects.UPZPU1;
import com.appnull.commands.notifications.subjects.UPZPU2;
//import com.appnull.commands.notifications.subjects.OS;
//import com.appnull.commands.notifications.subjects.KM;
//import com.appnull.commands.notifications.subjects.CS;

import com.appnull.commands.notifications.subjects.locations.TeamsLocation;
import com.appnull.commands.notifications.subjects.locations.ClassroomLocation;
//import com.appnull.commands.notifications.subjects.locations.NoLocation;
//import com.appnull.commands.notifications.subjects.locations.ShkoloLocation;
//import com.appnull.commands.notifications.subjects.locations.DiscordLocation;

import com.appnull.commands.notifications.subjects.times.FirstSubject;
import com.appnull.commands.notifications.subjects.times.SecondSubject;
import com.appnull.commands.notifications.subjects.times.ThirthSubject;
import com.appnull.commands.notifications.subjects.times.FourthSubject;
import com.appnull.commands.notifications.subjects.times.FifthSubject;
import com.appnull.commands.notifications.subjects.times.SixthSubject;
import com.appnull.commands.notifications.subjects.times.SeventhSubject;
import com.appnull.commands.notifications.subjects.times.EighthSubject;
//import com.appnull.commands.notifications.subjects.times.NinthSubject;

import com.appnull.commands.permissions.RoleMannager;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class ScheduleNotofications extends ListenerAdapter {

	private final List<String> scheduledTasksLog = new ArrayList<String>();
	private final Map<Integer, List<Subject>> schoolSchedule;
//	private Map<Boolean, GuildMessageReceivedEvent> inputConfig;

	private final DateTimeFormatter formatter;
	private final LocalDate endDate;
	private final Calendar calendar;
	private final Timer timer;

	private String reportScheduledTasksLog;

	public ScheduleNotofications() throws ParseException {

		this.formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		this.endDate = LocalDate.parse("30/06/2021 23:59:59", formatter);
		this.schoolSchedule = new HashedMap<Integer, List<Subject>>();
		this.calendar = Calendar.getInstance();
		this.timer = new Timer();

		// 1 is Sunday, 2 - Monday, 3 - Tuesday etc..
		ArrayList<Subject> mondays = new ArrayList<Subject>();
		ArrayList<Subject> tuesday = new ArrayList<Subject>();
		ArrayList<Subject> thirsday = new ArrayList<Subject>();
		ArrayList<Subject> wendesday = new ArrayList<Subject>();
		ArrayList<Subject> friday = new ArrayList<Subject>();

		schoolSchedule.put(2, mondays);
		mondays.add(new SubjectImpl(new ThirthSubject(), new TeamsLocation(), new GO()));
		mondays.add(new SubjectImpl(new FourthSubject(), new ClassroomLocation(), new BEL()));
		mondays.add(new SubjectImpl(new FifthSubject(), new TeamsLocation(), new ZPU()));
		mondays.add(new SubjectImpl(new SixthSubject(), new TeamsLocation(), new ZPU()));
		mondays.add(new SubjectImpl(new SeventhSubject(), new TeamsLocation(), new UPKM1()));
		mondays.add(new SubjectImpl(new SeventhSubject(), new TeamsLocation(), new UPKM2()));
		mondays.add(new SubjectImpl(new EighthSubject(), new TeamsLocation(), new UPKM1()));
		mondays.add(new SubjectImpl(new EighthSubject(), new TeamsLocation(), new UPKM2()));

		schoolSchedule.put(3, tuesday);
		tuesday.add(new SubjectImpl(new FirstSubject(), new TeamsLocation(), new BK()));
		tuesday.add(new SubjectImpl(new SecondSubject(), new TeamsLocation(), new BK()));
		tuesday.add(new SubjectImpl(new ThirthSubject(), new TeamsLocation(), new UPUMk1()));
		tuesday.add(new SubjectImpl(new ThirthSubject(), new TeamsLocation(), new UPUMk2()));
		tuesday.add(new SubjectImpl(new FourthSubject(), new TeamsLocation(), new UPUMk1()));
		tuesday.add(new SubjectImpl(new FourthSubject(), new TeamsLocation(), new UPUMk2()));
		tuesday.add(new SubjectImpl(new FifthSubject(), new TeamsLocation(), new UPOS1()));
		tuesday.add(new SubjectImpl(new FifthSubject(), new TeamsLocation(), new UPOS2()));
		tuesday.add(new SubjectImpl(new SixthSubject(), new TeamsLocation(), new UPOS1()));
		tuesday.add(new SubjectImpl(new SixthSubject(), new TeamsLocation(), new UPOS2()));
		tuesday.add(new SubjectImpl(new SeventhSubject(), new TeamsLocation(), new NE()));
		tuesday.add(new SubjectImpl(new EighthSubject(), new TeamsLocation(), new NE()));

		schoolSchedule.put(4, thirsday);
		thirsday.add(new SubjectImpl(new FirstSubject(), new TeamsLocation(), new UPKA1()));
		thirsday.add(new SubjectImpl(new FirstSubject(), new TeamsLocation(), new UPKA2()));
		thirsday.add(new SubjectImpl(new SecondSubject(), new TeamsLocation(), new UPKA1()));
		thirsday.add(new SubjectImpl(new SecondSubject(), new TeamsLocation(), new UPKA2()));
		thirsday.add(new SubjectImpl(new ThirthSubject(), new ClassroomLocation(), new BEL()));
		thirsday.add(new SubjectImpl(new FourthSubject(), new ClassroomLocation(), new BEL()));
		thirsday.add(new SubjectImpl(new FifthSubject(), new TeamsLocation(), new UPZPU1()));
		thirsday.add(new SubjectImpl(new FifthSubject(), new TeamsLocation(), new UPZPU2()));
		thirsday.add(new SubjectImpl(new SixthSubject(), new TeamsLocation(), new UPZPU1()));
		thirsday.add(new SubjectImpl(new SixthSubject(), new TeamsLocation(), new UPZPU2()));
		thirsday.add(new SubjectImpl(new SeventhSubject(), new TeamsLocation(), new ChKR()));
		thirsday.add(new SubjectImpl(new EighthSubject(), new TeamsLocation(), new SD()));

		schoolSchedule.put(5, wendesday);
		wendesday.add(new SubjectImpl(new SecondSubject(), new TeamsLocation(), new MAT()));
		wendesday.add(new SubjectImpl(new ThirthSubject(), new TeamsLocation(), new MAT()));
		wendesday.add(new SubjectImpl(new FourthSubject(), new TeamsLocation(), new PROG()));
		wendesday.add(new SubjectImpl(new FifthSubject(), new TeamsLocation(), new PROG()));
		wendesday.add(new SubjectImpl(new SixthSubject(), new TeamsLocation(), new FVS()));
		wendesday.add(new SubjectImpl(new SeventhSubject(), new TeamsLocation(), new FVS()));

		schoolSchedule.put(6, friday);
		friday.add(new SubjectImpl(new ThirthSubject(), new TeamsLocation(), new UPKA1()));
		friday.add(new SubjectImpl(new ThirthSubject(), new TeamsLocation(), new UPKA2()));
		friday.add(new SubjectImpl(new FourthSubject(), new TeamsLocation(), new UPKA1()));
		friday.add(new SubjectImpl(new FourthSubject(), new TeamsLocation(), new UPKA2()));
		friday.add(new SubjectImpl(new FifthSubject(), new TeamsLocation(), new KA()));
		friday.add(new SubjectImpl(new SixthSubject(), new TeamsLocation(), new KA()));
		friday.add(new SubjectImpl(new SeventhSubject(), new TeamsLocation(), new ChEP()));

	}

	private boolean getAccessMember(GuildMessageReceivedEvent event) {
		Member owner = event.getGuild().getMemberById("266695705786056704");
		Member currentMember = event.getMember();
		Member accessMember;

		accessMember = event.getGuild().getMemberById("318688044523716608");

		boolean writeaccess = event.getMember().hasPermission(net.dv8tion.jda.api.Permission.MESSAGE_WRITE);

		if (writeaccess == true || currentMember.equals(owner) || currentMember.equals(accessMember)) {
			return true;

		} else {
			return false;
		}
	}

	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

//		inputConfig = new HashMap<Boolean, GuildMessageReceivedEvent>();

		RoleMannager roleMannager = new RoleMannager();
		String message = event.getMessage().getContentRaw();

		List<CommandHandler> handlers = new ArrayList<>();
		handlers.add(new AddRoleCommand());
		handlers.add(new RemoveRoleCommand());
		handlers.add(new HelpssCommand());

		for (CommandHandler handler : handlers) {
			if (handler.canHandle(event)) {
				handler.handle(event, "266695705786056704");
			} else {
				event.getMessage().delete().queue();
			}
		}

		if (message.contains("!Allah")) {
			roleMannager.automatical(event, "266695705786056704", true);
		}

		if (message.contains("!NoAllah")) {
			roleMannager.automatical(event, "266695705786056704", false);
		}

		if (message.contentEquals("!getcodes")) {

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

		if (message.contentEquals("!kys") || message.contentEquals("!KYS")) {
			if (event.getMember().equals(event.getGuild().getMemberById("266695705786056704"))) {
				event.getChannel().sendMessage("I love you too " + event.getMember().getAsMention()).queue();

			} else {
				event.getChannel().sendMessage("NO! KYS " + event.getMember().getAsMention()).queue();
			}
		}

		if (message.contentEquals("!report")) {
			event.getChannel().sendMessage(reportScheduledTasksLog).queue();

		}

		if (getAccessMember(event)) {
			if (message.contentEquals("!schedule")) {

				try {
					scheduleTasks(event);

				} catch (IOException | ParseException e) {
					event.getChannel().sendMessage("Error!").queue();
				}
			}

			if (message.contentEquals("!getschedule")) {

				event.getChannel().sendMessage("**CraftCN | " + "Server: `" + event.getGuild().getName()
						+ "` End-Date: `" + endDate + "`** **Scheduler: " + event.getMember().getAsMention() + "**")
						.queue();
				for (String task : scheduledTasksLog) {
					event.getChannel().sendMessage(task).queue();
				}
			}

		} else if (message.contentEquals("!schedule")
				|| message.contentEquals("!getschedule") && !getAccessMember(event)) {

			event.getChannel().sendMessage("**CraftCN Error | " + event.getMember().getAsMention()
					+ "** Null-Permitions" + "\nUse **!helpss** for more information!").queue();
			event.getMessage().delete().queue();
		}
	}

	private void scheduleLogReport() {
		String Report = "";
		String logReport = Report;

		for (int l = 0; scheduledTasksLog.size() > l; l++) {
			if (scheduledTasksLog.get(l).contains("LL")) {
				Report = "1";

			} else {
				Report = "0";

			}
			logReport += Report;
		}
		this.reportScheduledTasksLog = logReport;

	}

	private void scheduleTasks(GuildMessageReceivedEvent event) throws ParseException, IOException {
		System.out.println("CraftCN " + "Server: " + event.getGuild() + " End-Date: " + endDate + " Scheduler: "
				+ event.getMember().getUser());

		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		LocalDate startDate = LocalDate.now();

		for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {
			if (LocalTime.now().getHour() > 12 && LocalDate.now().isEqual(date)) {
				continue;
			}

			java.sql.Date calendarDate = java.sql.Date.valueOf(date);
			calendar.setTime(calendarDate);

			int weekday = calendar.get(Calendar.DAY_OF_WEEK);

			if (schoolSchedule.containsKey(weekday)) {
				List<Subject> subjects = schoolSchedule.get(weekday);

				for (int i = 0; i < subjects.size(); i++) {

					Subject subject = subjects.get(i);
					LocalTime hoursAndMin = subject.getStartTime();

					String dateString = date.toString() + " " + hoursAndMin;
					Date scheduledTime = dateFormater.parse(dateString);

					int max = 999999999;
					int min = 987654321;
					int accessToken = (int) (Math.random() * (max - min + 1) + min);

					String loc = "";

					if (subject.getLocation() == "Teams") {
						loc = subject.getLocation();
					} else if (subject.getLocation() == "Classroom") {
						loc = subject.getLocation();
					} else {
						loc = "NULL";
					}

					String logMessageSOUT = "CraftCN " + accessToken + "-accessToken " + "Scheduled task for: "
							+ scheduledTime + " Subject: " + subject.getName() + " [" + subject.getPosition() + "] - "
							+ loc + " " + subject.getCode();

					String logMessageJDA = "**CraftCN** ||" + accessToken + "-accessToken|| "
							+ "**Scheduled task for:** `" + scheduledTime + "` **Subject:** `" + subject.getName()
							+ "` **# " + subject.getPosition() + " | `" + loc + "` ||" + subject.getCode() + "||**";

					System.out.println(logMessageSOUT);

					this.scheduledTasksLog.add(logMessageJDA);
					scheduleLogReport();

					timer.schedule(new Notify(event, subject), scheduledTime);

				}
			}
		}
	}

	public static void a(String a) {
		a = "a";
	}

	public static void main(String[] args) {
		String b = "b";
		ScheduleNotofications.a(b);
		System.out.println(b);
	}
}
