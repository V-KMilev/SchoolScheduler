package com.appnull.commands.schedule;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import org.apache.commons.collections4.map.HashedMap;

import com.appnull.commands.notifications.Notify;
import com.appnull.commands.notifications.base.Subject;
import com.appnull.commands.notifications.base.SubjectImpl;
import com.appnull.commands.notifications.subjects.BEL;
import com.appnull.commands.notifications.subjects.BK;
import com.appnull.commands.notifications.subjects.ChEP;
import com.appnull.commands.notifications.subjects.ChKR;
import com.appnull.commands.notifications.subjects.FVS;
import com.appnull.commands.notifications.subjects.GO;
import com.appnull.commands.notifications.subjects.KA;
import com.appnull.commands.notifications.subjects.MAT;
import com.appnull.commands.notifications.subjects.NE;
import com.appnull.commands.notifications.subjects.PROG;
import com.appnull.commands.notifications.subjects.SD;
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
import com.appnull.commands.notifications.subjects.ZPU;
import com.appnull.commands.notifications.subjects.locations.ClassroomLocation;
import com.appnull.commands.notifications.subjects.locations.TeamsLocation;
import com.appnull.commands.notifications.subjects.times.EighthSubject;
import com.appnull.commands.notifications.subjects.times.FifthSubject;
import com.appnull.commands.notifications.subjects.times.FirstSubject;
import com.appnull.commands.notifications.subjects.times.FourthSubject;
import com.appnull.commands.notifications.subjects.times.SecondSubject;
import com.appnull.commands.notifications.subjects.times.SeventhSubject;
import com.appnull.commands.notifications.subjects.times.SixthSubject;
import com.appnull.commands.notifications.subjects.times.ThirthSubject;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class Schedule {

	private final List<String> scheduledTasksLog = new ArrayList<String>();
	private final Map<Integer, List<Subject>> schoolSchedule;
	private final DateTimeFormatter formatter;
	private final LocalDate endDate;
	private final Calendar calendar;
	private final Timer timer;

	public Schedule() {

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

	public LocalDate getEndDate() {
		return endDate;

	}

	public List<String> getScheduledTasksLog() {
		return scheduledTasksLog;

	}

	public void scheduleTasks(GuildMessageReceivedEvent event) throws ParseException, IOException {
		System.out.println("CraftCN " + "Server: " + event.getGuild() + " End-Date: " + getEndDate() + " Scheduler: "
				+ event.getMember().getUser());

		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		LocalDate startDate = LocalDate.now();

		for (LocalDate date = startDate; date.isBefore(getEndDate()); date = date.plusDays(1)) {
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

					this.getScheduledTasksLog().add(logMessageJDA);

					timer.schedule(new Notify(event, subject), scheduledTime);

				}
			}
		}
	}
}
