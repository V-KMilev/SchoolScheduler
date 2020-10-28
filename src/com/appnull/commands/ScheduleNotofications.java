package com.appnull.commands;

//import java.io.FileWriter;
import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Timer;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import org.apache.commons.collections4.map.HashedMap;

//import com.appnull.commands.accounts.Account;
//import com.appnull.commands.accounts.AccountManager;
//import com.appnull.commands.accounts.subjects.copy.accountName1;
//import com.appnull.commands.accounts.subjects.copy.accountPassword1;

import com.appnull.commands.notifications.Notify;
import com.appnull.commands.notifications.Subject;
import com.appnull.commands.notifications.SubjectImpl;


import com.appnull.commands.notifications.subjects.BEL;
import com.appnull.commands.notifications.subjects.CS;
import com.appnull.commands.notifications.subjects.ChEP;
import com.appnull.commands.notifications.subjects.ChKR;
import com.appnull.commands.notifications.subjects.FVS;
import com.appnull.commands.notifications.subjects.GO;
import com.appnull.commands.notifications.subjects.KA;
import com.appnull.commands.notifications.subjects.KAPv1;
import com.appnull.commands.notifications.subjects.KAPv2;
import com.appnull.commands.notifications.subjects.KM;
import com.appnull.commands.notifications.subjects.Mat;
import com.appnull.commands.notifications.subjects.NE;
import com.appnull.commands.notifications.subjects.OS;
import com.appnull.commands.notifications.subjects.OSPv1;
import com.appnull.commands.notifications.subjects.OSPv2;
import com.appnull.commands.notifications.subjects.SD;
import com.appnull.commands.notifications.subjects.UPCv1;
import com.appnull.commands.notifications.subjects.UPCv2;
import com.appnull.commands.notifications.subjects.UPZPUv1;
import com.appnull.commands.notifications.subjects.UPZPUv2;
import com.appnull.commands.notifications.subjects.ZPU;

import com.appnull.commands.notifications.subjects.locations.TeamsLocation;
//import com.appnull.commands.notifications.subjects.locations.ShkoloLocation;
//import com.appnull.commands.notifications.subjects.locations.ClassroomLocation;
//import com.appnull.commands.notifications.subjects.locations.DiscordLocation;

import com.appnull.commands.notifications.subjects.times.FirstSubject;
import com.appnull.commands.notifications.subjects.times.SecondSubject;
import com.appnull.commands.notifications.subjects.times.ThirthSubject;
import com.appnull.commands.notifications.subjects.times.FourthSubject;
import com.appnull.commands.notifications.subjects.times.NinthSubject;
import com.appnull.commands.notifications.subjects.times.FifthSubject;
import com.appnull.commands.notifications.subjects.times.SixthSubject;
import com.appnull.commands.notifications.subjects.times.SeventhSubject;
import com.appnull.commands.notifications.subjects.times.EighthSubject;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.entities.Member;

public class ScheduleNotofications extends ListenerAdapter {

	private final Map<Integer, List<Subject>> schoolSchedule;
	private final List<String> scheduledTasksLog = new ArrayList<String>();

	private final LocalDate endDate;
	private final Calendar calendar;
	private final DateTimeFormatter formatter;
	private final Timer timer;

	public ScheduleNotofications() throws ParseException {
		this.timer = new Timer();
		this.schoolSchedule = new HashedMap<Integer, List<Subject>>();
		this.formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		this.endDate = LocalDate.parse("12/11/2020 00:00:00", formatter);
		this.calendar = Calendar.getInstance();
		// 1 is Sunday, 2 - Monday, 3 - Tuesday etc..

		ArrayList<Subject> mondays = new ArrayList<Subject>();
		ArrayList<Subject> tuesday = new ArrayList<Subject>();
		ArrayList<Subject> thirsday = new ArrayList<Subject>();
		ArrayList<Subject> wendesday = new ArrayList<Subject>();
		ArrayList<Subject> friday = new ArrayList<Subject>();

		schoolSchedule.put(2, mondays);
		mondays.add(new SubjectImpl(new FirstSubject(), new TeamsLocation(), new CS()));
		mondays.add(new SubjectImpl(new SecondSubject(), new TeamsLocation(), new CS()));
		mondays.add(new SubjectImpl(new ThirthSubject(), new TeamsLocation(), new FVS()));
		mondays.add(new SubjectImpl(new FourthSubject(), new TeamsLocation(), new FVS()));
		mondays.add(new SubjectImpl(new FifthSubject(), new TeamsLocation(), new GO()));
		mondays.add(new SubjectImpl(new SixthSubject(), new TeamsLocation(), new Mat()));
		mondays.add(new SubjectImpl(new SeventhSubject(), new TeamsLocation(), new Mat()));

		schoolSchedule.put(3, tuesday);
		tuesday.add(new SubjectImpl(new FirstSubject(), new TeamsLocation(), new NE()));
		tuesday.add(new SubjectImpl(new SecondSubject(), new TeamsLocation(), new NE()));
		tuesday.add(new SubjectImpl(new ThirthSubject(), new TeamsLocation(), new KAPv1()));
		tuesday.add(new SubjectImpl(new ThirthSubject(), new TeamsLocation(), new KAPv2()));
		tuesday.add(new SubjectImpl(new FourthSubject(), new TeamsLocation(), new KAPv1()));
		tuesday.add(new SubjectImpl(new FourthSubject(), new TeamsLocation(), new KAPv2()));
		tuesday.add(new SubjectImpl(new FifthSubject(), new TeamsLocation(), new ZPU()));
		tuesday.add(new SubjectImpl(new SixthSubject(), new TeamsLocation(), new ZPU()));

		schoolSchedule.put(4, thirsday);
		thirsday.add(new SubjectImpl(new ThirthSubject(), new TeamsLocation(), new KAPv1()));
		thirsday.add(new SubjectImpl(new ThirthSubject(), new TeamsLocation(), new KAPv2()));
		thirsday.add(new SubjectImpl(new FourthSubject(), new TeamsLocation(), new KAPv1()));
		thirsday.add(new SubjectImpl(new FourthSubject(), new TeamsLocation(), new KAPv2()));
		thirsday.add(new SubjectImpl(new FifthSubject(), new TeamsLocation(), new UPCv1()));
		thirsday.add(new SubjectImpl(new FifthSubject(), new TeamsLocation(), new UPCv2()));
		thirsday.add(new SubjectImpl(new SixthSubject(), new TeamsLocation(), new UPCv1()));
		thirsday.add(new SubjectImpl(new SixthSubject(), new TeamsLocation(), new UPCv2()));
		thirsday.add(new SubjectImpl(new SeventhSubject(), new TeamsLocation(), new SD()));
		thirsday.add(new SubjectImpl(new EighthSubject(), new TeamsLocation(), new OSPv1()));
		thirsday.add(new SubjectImpl(new EighthSubject(), new TeamsLocation(), new OSPv2()));
		thirsday.add(new SubjectImpl(new NinthSubject(), new TeamsLocation(), new OSPv1()));
		thirsday.add(new SubjectImpl(new NinthSubject(), new TeamsLocation(), new OSPv2()));

		schoolSchedule.put(5, wendesday);
		wendesday.add(new SubjectImpl(new FirstSubject(), new TeamsLocation(), new KA()));
		wendesday.add(new SubjectImpl(new SecondSubject(), new TeamsLocation(), new KA()));
		wendesday.add(new SubjectImpl(new ThirthSubject(), new TeamsLocation(), new KM()));
		wendesday.add(new SubjectImpl(new FourthSubject(), new TeamsLocation(), new KM()));
		wendesday.add(new SubjectImpl(new FifthSubject(), new TeamsLocation(), new UPZPUv1()));
		wendesday.add(new SubjectImpl(new FifthSubject(), new TeamsLocation(), new UPZPUv2()));
		wendesday.add(new SubjectImpl(new SixthSubject(), new TeamsLocation(), new UPZPUv1()));
		wendesday.add(new SubjectImpl(new SixthSubject(), new TeamsLocation(), new UPZPUv2()));
		wendesday.add(new SubjectImpl(new SeventhSubject(), new TeamsLocation(), new BEL()));

		schoolSchedule.put(6, friday);
		friday.add(new SubjectImpl(new ThirthSubject(), new TeamsLocation(), new BEL()));
		friday.add(new SubjectImpl(new FourthSubject(), new TeamsLocation(), new BEL()));
		friday.add(new SubjectImpl(new FifthSubject(), new TeamsLocation(), new ChEP()));
		friday.add(new SubjectImpl(new SixthSubject(), new TeamsLocation(), new ChEP()));
		friday.add(new SubjectImpl(new SeventhSubject(), new TeamsLocation(), new ChKR()));
		friday.add(new SubjectImpl(new EighthSubject(), new TeamsLocation(), new OS()));
		friday.add(new SubjectImpl(new NinthSubject(), new TeamsLocation(), new OS()));

	}

	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

		String message = event.getMessage().getContentRaw();

		Member acsessMember = event.getGuild().getMemberById("266695705786056704");
		Member currentMember = event.getMember();

		if (message.contentEquals("!schedule") && currentMember.equals(acsessMember)) {
			try {
				scheduleTasks(event);
			} catch (ParseException | IOException e) {
				event.getChannel().sendMessage("Error!").queue();
			}

		} else if (message.contentEquals("!schedule") && !currentMember.equals(acsessMember)) {
			event.getChannel().sendMessage("Error! You don't have access..\n:(").queue();
			event.getMessage().delete().queue();
		}

		if (message.contentEquals("!getschedule") && currentMember.equals(acsessMember)) {
			event.getChannel().sendMessage("CraftCN End-Date: " + endDate).queue();
			for (String task : scheduledTasksLog) {
				event.getChannel().sendMessage(task).queue();
			}
		} else if (message.contentEquals("!getscheduleNo") && !currentMember.equals(acsessMember)) {
			event.getChannel().sendMessage("Error! You don't have access.. \n:(").queue();
			event.getMessage().delete().queue();
		}

		if (message.contentEquals("!help")) {
			event.getChannel()
					.sendMessage(
							"- !schedule (Създаване на програма..)" + "\n- !getschedule (Принтиране на програмата..)")
					.queue();
		}

	}

	private void scheduleTasks(GuildMessageReceivedEvent event) throws ParseException, IOException {
		System.out.println("CraftCN End-Date: " + endDate);

		LocalDate startDate = LocalDate.now();
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm");

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

					String logMessage = "CraftCN " + Math.random() + "-accessToken " // + accessMember.getUser()
							+ " Scheduled task for: " + scheduledTime + " for: " + subject.getName();

					System.out.println(logMessage);
					this.scheduledTasksLog.add(logMessage);

//					FileWriter writer = new FileWriter("logMessage.txt");
//					writer.write(logMessage + "\n");

					timer.schedule(new Notify(event, subject), scheduledTime);

				}
			}
		}
	}
}
