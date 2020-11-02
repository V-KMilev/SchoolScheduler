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

import com.appnull.commands.notifications.Notify;
import com.appnull.commands.notifications.Subject;
import com.appnull.commands.notifications.SubjectImpl;

import com.appnull.commands.notifications.subjects.CS;
import com.appnull.commands.notifications.subjects.GO;
import com.appnull.commands.notifications.subjects.KA;
import com.appnull.commands.notifications.subjects.KM;
import com.appnull.commands.notifications.subjects.NE;
import com.appnull.commands.notifications.subjects.OS;
import com.appnull.commands.notifications.subjects.SD;
import com.appnull.commands.notifications.subjects.BEL;
import com.appnull.commands.notifications.subjects.FVS;
import com.appnull.commands.notifications.subjects.Mat;
import com.appnull.commands.notifications.subjects.ZPU;
import com.appnull.commands.notifications.subjects.ChEP;
import com.appnull.commands.notifications.subjects.ChKR;
import com.appnull.commands.notifications.subjects.KAPv1;
import com.appnull.commands.notifications.subjects.KAPv2;
import com.appnull.commands.notifications.subjects.OSPv1;
import com.appnull.commands.notifications.subjects.OSPv2;
import com.appnull.commands.notifications.subjects.UPCv1;
import com.appnull.commands.notifications.subjects.UPCv2;
import com.appnull.commands.notifications.subjects.UPZPUv1;
import com.appnull.commands.notifications.subjects.UPZPUv2;

import com.appnull.commands.notifications.subjects.locations.TeamsLocation;
//import com.appnull.commands.notifications.subjects.locations.ShkoloLocation;
//import com.appnull.commands.notifications.subjects.locations.ClassroomLocation;
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

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class ScheduleNotofications extends ListenerAdapter {

	private final List<String> scheduledTasksLog = new ArrayList<String>();
	private final List<String> accessMembers = new ArrayList<String>();
	private final Map<Integer, List<Subject>> schoolSchedule;

	private final DateTimeFormatter formatter;
	private final LocalDate endDate;
	private final Calendar calendar;
	private final Timer timer;

	public ScheduleNotofications() throws ParseException {

		this.formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		this.endDate = LocalDate.parse("13/11/2020 23:59:59", formatter);
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
		mondays.add(new SubjectImpl(new FirstSubject(), new TeamsLocation(), new SD()));
		mondays.add(new SubjectImpl(new SecondSubject(), new TeamsLocation(), new KAPv1()));
		mondays.add(new SubjectImpl(new SecondSubject(), new TeamsLocation(), new KAPv2()));
		mondays.add(new SubjectImpl(new ThirthSubject(), new TeamsLocation(), new KAPv1()));
		mondays.add(new SubjectImpl(new ThirthSubject(), new TeamsLocation(), new KAPv2()));
		mondays.add(new SubjectImpl(new FourthSubject(), new TeamsLocation(), new OSPv1()));
		mondays.add(new SubjectImpl(new FourthSubject(), new TeamsLocation(), new OSPv2()));
		mondays.add(new SubjectImpl(new FifthSubject(), new TeamsLocation(), new OSPv1()));
		mondays.add(new SubjectImpl(new FifthSubject(), new TeamsLocation(), new OSPv2()));
		mondays.add(new SubjectImpl(new SixthSubject(), new TeamsLocation(), new UPCv1()));
		mondays.add(new SubjectImpl(new SixthSubject(), new TeamsLocation(), new UPCv2()));
		mondays.add(new SubjectImpl(new SeventhSubject(), new TeamsLocation(), new UPCv1()));
		mondays.add(new SubjectImpl(new SeventhSubject(), new TeamsLocation(), new UPCv2()));

		schoolSchedule.put(3, tuesday);
		tuesday.add(new SubjectImpl(new SecondSubject(), new TeamsLocation(), new BEL()));
		tuesday.add(new SubjectImpl(new ThirthSubject(), new TeamsLocation(), new KAPv1()));
		tuesday.add(new SubjectImpl(new ThirthSubject(), new TeamsLocation(), new KAPv2()));
		
//		tuesday.add(new SubjectImpl(new SecondSubject(), new TeamsLocation(), new BEL()));
//		tuesday.add(new SubjectImpl(new ThirthSubject(), new TeamsLocation(), new KA()));
		tuesday.add(new SubjectImpl(new FourthSubject(), new TeamsLocation(), new KA()));
		tuesday.add(new SubjectImpl(new FifthSubject(), new TeamsLocation(), new CS()));
		tuesday.add(new SubjectImpl(new SixthSubject(), new TeamsLocation(), new CS()));
		tuesday.add(new SubjectImpl(new SeventhSubject(), new TeamsLocation(), new ChEP()));
		tuesday.add(new SubjectImpl(new EighthSubject(), new TeamsLocation(), new ChEP()));

		schoolSchedule.put(4, thirsday);
		thirsday.add(new SubjectImpl(new SecondSubject(), new TeamsLocation(), new ChKR()));
		thirsday.add(new SubjectImpl(new ThirthSubject(), new TeamsLocation(), new FVS()));
		thirsday.add(new SubjectImpl(new FourthSubject(), new TeamsLocation(), new FVS()));
		thirsday.add(new SubjectImpl(new FifthSubject(), new TeamsLocation(), new UPZPUv1()));
		thirsday.add(new SubjectImpl(new FifthSubject(), new TeamsLocation(), new UPZPUv2()));
		thirsday.add(new SubjectImpl(new SixthSubject(), new TeamsLocation(), new UPZPUv1()));
		thirsday.add(new SubjectImpl(new SixthSubject(), new TeamsLocation(), new UPZPUv2()));
		thirsday.add(new SubjectImpl(new SeventhSubject(), new TeamsLocation(), new KAPv1()));
		thirsday.add(new SubjectImpl(new SeventhSubject(), new TeamsLocation(), new KAPv2()));
		thirsday.add(new SubjectImpl(new EighthSubject(), new TeamsLocation(), new KAPv1()));
		thirsday.add(new SubjectImpl(new EighthSubject(), new TeamsLocation(), new KAPv2()));

		schoolSchedule.put(5, wendesday);
		wendesday.add(new SubjectImpl(new FirstSubject(), new TeamsLocation(), new KM()));
		wendesday.add(new SubjectImpl(new SecondSubject(), new TeamsLocation(), new KM()));
		wendesday.add(new SubjectImpl(new ThirthSubject(), new TeamsLocation(), new Mat()));
		wendesday.add(new SubjectImpl(new FourthSubject(), new TeamsLocation(), new Mat()));
		wendesday.add(new SubjectImpl(new FifthSubject(), new TeamsLocation(), new GO()));
		wendesday.add(new SubjectImpl(new SixthSubject(), new TeamsLocation(), new NE()));
		wendesday.add(new SubjectImpl(new SeventhSubject(), new TeamsLocation(), new NE()));

		schoolSchedule.put(6, friday);
		friday.add(new SubjectImpl(new FirstSubject(), new TeamsLocation(), new BEL()));
		friday.add(new SubjectImpl(new SecondSubject(), new TeamsLocation(), new BEL()));
		friday.add(new SubjectImpl(new ThirthSubject(), new TeamsLocation(), new OS()));
		friday.add(new SubjectImpl(new FourthSubject(), new TeamsLocation(), new OS()));
		friday.add(new SubjectImpl(new FifthSubject(), new TeamsLocation(), new ZPU()));
		friday.add(new SubjectImpl(new SixthSubject(), new TeamsLocation(), new ZPU()));

	}

	private boolean getAccessMember(GuildMessageReceivedEvent event) {
		Member currentMember = event.getMember();
		Member accessMember;

		boolean access = false;

		accessMembers.add("266695705786056704");
//		accessMembers.add("176728844034637824");
//		accessMembers.add("318688044523716608");

		for (int i = 0; i < accessMembers.size(); i++) {

			accessMember = event.getGuild().getMemberById(accessMembers.get(i));
			access = currentMember.equals(accessMember);
		}

		return access;
	}

	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

		String message = event.getMessage().getContentRaw();

		if (message.contentEquals("!helpss")) {

			EmbedBuilder eb = new EmbedBuilder();

			eb.setTitle("QSG - HELP");
			eb.addField("- !schedule", "Създаване на програма.", true);
			eb.addField("- !getschedule", "Принтиране на програмата.", true);
			eb.setFooter("For more help CurrentlyNull#3126 or vilimir.k.milev@gmail.com");

			eb.setColor(Color.RED);
			eb.setThumbnail("https://cdn.discordapp.com/attachments/711858389067759708/772785636029104158/haah.png");

			event.getChannel().sendMessage(eb.build()).queue();
		}

		if (getAccessMember(event)) {
			if (message.contentEquals("!schedule")) {

				try {
					scheduleTasks(event);
				} catch (ParseException | IOException e) {
					event.getChannel().sendMessage("Error!").queue();
				}
			}

			if (message.contentEquals("!getschedule")) {

				event.getChannel().sendMessage("CraftCN End-Date: " + endDate).queue();
				for (String task : scheduledTasksLog) {
					event.getChannel().sendMessage(task).queue();
				}
			}
		} else if (message.contentEquals("!schedule")
				|| message.contentEquals("!getschedule") && !getAccessMember(event)) {

			event.getChannel().sendMessage("Error! You don't have access..\n:(").queue();
			event.getMessage().delete().queue();
		}
	}

	private void scheduleTasks(GuildMessageReceivedEvent event) throws ParseException, IOException {
		System.out.println("CraftCN End-Date: " + endDate);

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
					int min = 900000000;
					int accessToken = (int) (Math.random() * (max - min + 1) + min);

					String logMessage = "CraftCN " + accessToken + "-accessToken " + // accessMember.getUser() +
							"Scheduled task for: " + scheduledTime + " for: " + subject.getName();

					System.out.println(logMessage);
					this.scheduledTasksLog.add(logMessage);

					timer.schedule(new Notify(event, subject), scheduledTime);

				}
			}
		}
	}
}
