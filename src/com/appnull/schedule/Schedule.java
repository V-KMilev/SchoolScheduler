package com.appnull.schedule;

import java.io.IOException;
import java.io.InputStream;
import java.io.FileNotFoundException;

import java.util.Map;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Properties;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.collections4.map.HashedMap;

import com.appnull.subject.Subject;
import com.appnull.subject.SubjectImpl;
import com.appnull.notifications.Notify;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class Schedule {

	private final List<String> scheduledTasksLog = new ArrayList<String>();
	private final Map<Integer, List<Subject>> schoolSchedule;

	private final String setEndDate = "27/03/2021 23:59:59";
	private final String propFileTime = "subjects.properties";

	private final Properties prop = new Properties();

	private final DateTimeFormatter formatter;
	private final LocalDate endDate;
	private final Timer timer;
	private final Calendar calendar;

	private InputStream inputStream;

	public Schedule() {

		this.formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		this.endDate = LocalDate.parse(setEndDate, formatter);
		this.schoolSchedule = new HashedMap<Integer, List<Subject>>();
		this.calendar = Calendar.getInstance();
		this.timer = new Timer();

		// 1 is Sunday, 2 - Monday, 3 - Tuesday etc..
		ArrayList<Subject> mondays = new ArrayList<Subject>();
		ArrayList<Subject> tuesday = new ArrayList<Subject>();
		ArrayList<Subject> thirsday = new ArrayList<Subject>();
		ArrayList<Subject> wendesday = new ArrayList<Subject>();
		ArrayList<Subject> friday = new ArrayList<Subject>();

		try {

			inputStream = getClass().getClassLoader().getResourceAsStream(propFileTime);

			if (inputStream != null)
				prop.load(inputStream);
			else
				throw new FileNotFoundException(
						"Property file '" + inputStream + "' not found in the classpath!");

			schoolSchedule.put(2, mondays);

			mondays.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("thirthSubject.startTime")),
					LocalTime.parse(prop.getProperty("thirthSubject.endTime")),
					Integer.parseInt(prop.getProperty("thirthSubject.position")), prop.getProperty("GO.name"),
					prop.getProperty("GO.code")));
			mondays.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("fourthSubject.startTime")),
					LocalTime.parse(prop.getProperty("fourthSubject.endTime")),
					Integer.parseInt(prop.getProperty("fourthSubject.position")), prop.getProperty("BEL.name"),
					prop.getProperty("BEL.code")));
			mondays.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("fifthSubject.startTime")),
					LocalTime.parse(prop.getProperty("fifthSubject.endTime")),
					Integer.parseInt(prop.getProperty("fifthSubject.position")), prop.getProperty("ZPU.name"),
					prop.getProperty("ZPU.code")));
			mondays.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("sixthSubject.startTime")),
					LocalTime.parse(prop.getProperty("sixthSubject.endTime")),
					Integer.parseInt(prop.getProperty("sixthSubject.position")), prop.getProperty("ZPU.name"),
					prop.getProperty("ZPU.code")));
			mondays.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("seventhSubject.startTime")),
					LocalTime.parse(prop.getProperty("seventhSubject.endTime")),
					Integer.parseInt(prop.getProperty("seventhSubject.position")), prop.getProperty("UPKM1.name"),
					prop.getProperty("UPKM1.code")));
			mondays.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("seventhSubject.startTime")),
					LocalTime.parse(prop.getProperty("seventhSubject.endTime")),
					Integer.parseInt(prop.getProperty("seventhSubject.position")), prop.getProperty("UPKM2.name"),
					prop.getProperty("UPKM2.code")));
			mondays.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("eightSubject.startTime")),
					LocalTime.parse(prop.getProperty("eightSubject.endTime")),
					Integer.parseInt(prop.getProperty("eightSubject.position")), prop.getProperty("UPKM1.name"),
					prop.getProperty("UPKM1.code")));
			mondays.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("eightSubject.startTime")),
					LocalTime.parse(prop.getProperty("eightSubject.endTime")),
					Integer.parseInt(prop.getProperty("eightSubject.position")), prop.getProperty("UPKM2.name"),
					prop.getProperty("UPKM2.code")));

			schoolSchedule.put(3, tuesday);

			tuesday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("firstSubject.startTime")),
					LocalTime.parse(prop.getProperty("firstSubject.endTime")),
					Integer.parseInt(prop.getProperty("firstSubject.position")), prop.getProperty("BK.name"),
					prop.getProperty("BK.code")));
			tuesday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("secondSubject.startTime")),
					LocalTime.parse(prop.getProperty("secondSubject.endTime")),
					Integer.parseInt(prop.getProperty("secondSubject.position")), prop.getProperty("BK.name"),
					prop.getProperty("BK.code")));
			tuesday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("thirthSubject.startTime")),
					LocalTime.parse(prop.getProperty("thirthSubject.endTime")),
					Integer.parseInt(prop.getProperty("thirthSubject.position")), prop.getProperty("UPUMk1.name"),
					prop.getProperty("UPUMk1.code")));
			tuesday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("thirthSubject.startTime")),
					LocalTime.parse(prop.getProperty("thirthSubject.endTime")),
					Integer.parseInt(prop.getProperty("thirthSubject.position")), prop.getProperty("UPUMk2.name"),
					prop.getProperty("UPUMk2.code")));
			tuesday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("fourthSubject.startTime")),
					LocalTime.parse(prop.getProperty("fourthSubject.endTime")),
					Integer.parseInt(prop.getProperty("fourthSubject.position")), prop.getProperty("UPUMk1.name"),
					prop.getProperty("UPUMk1.code")));
			tuesday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("fourthSubject.startTime")),
					LocalTime.parse(prop.getProperty("fourthSubject.endTime")),
					Integer.parseInt(prop.getProperty("fourthSubject.position")), prop.getProperty("UPUMk2.name"),
					prop.getProperty("UPUMk2.code")));
			tuesday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("fifthSubject.startTime")),
					LocalTime.parse(prop.getProperty("fifthSubject.endTime")),
					Integer.parseInt(prop.getProperty("fifthSubject.position")), prop.getProperty("UPOS1.name"),
					prop.getProperty("UPOS1.code")));
			tuesday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("fifthSubject.startTime")),
					LocalTime.parse(prop.getProperty("fifthSubject.endTime")),
					Integer.parseInt(prop.getProperty("fifthSubject.position")), prop.getProperty("UPOS2.name"),
					prop.getProperty("UPOS2.code")));
			tuesday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("sixthSubject.startTime")),
					LocalTime.parse(prop.getProperty("sixthSubject.endTime")),
					Integer.parseInt(prop.getProperty("sixthSubject.position")), prop.getProperty("UPOS1.name"),
					prop.getProperty("UPOS1.code")));
			tuesday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("sixthSubject.startTime")),
					LocalTime.parse(prop.getProperty("sixthSubject.endTime")),
					Integer.parseInt(prop.getProperty("sixthSubject.position")), prop.getProperty("UPOS2.name"),
					prop.getProperty("UPOS2.code")));
			tuesday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("seventhSubject.startTime")),
					LocalTime.parse(prop.getProperty("seventhSubject.endTime")),
					Integer.parseInt(prop.getProperty("seventhSubject.position")), prop.getProperty("UPUMk1.name"),
					prop.getProperty("UPUMk1.code")));
			tuesday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("seventhSubject.startTime")),
					LocalTime.parse(prop.getProperty("seventhSubject.endTime")),
					Integer.parseInt(prop.getProperty("seventhSubject.position")), prop.getProperty("UPUMk2.name"),
					prop.getProperty("UPUMk2.code")));
			tuesday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("eightSubject.startTime")),
					LocalTime.parse(prop.getProperty("eightSubject.endTime")),
					Integer.parseInt(prop.getProperty("eightSubject.position")), prop.getProperty("UPUMk1.name"),
					prop.getProperty("UPUMk1.code")));
			tuesday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("eightSubject.startTime")),
					LocalTime.parse(prop.getProperty("eightSubject.endTime")),
					Integer.parseInt(prop.getProperty("eightSubject.position")), prop.getProperty("UPUMk2.name"),
					prop.getProperty("UPUMk2.code")));

			schoolSchedule.put(4, thirsday);

			thirsday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("firstSubject.startTime")),
					LocalTime.parse(prop.getProperty("firstSubject.endTime")),
					Integer.parseInt(prop.getProperty("firstSubject.position")), prop.getProperty("UPKA1.name"),
					prop.getProperty("UPKA1.code")));
			thirsday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("firstSubject.startTime")),
					LocalTime.parse(prop.getProperty("firstSubject.endTime")),
					Integer.parseInt(prop.getProperty("firstSubject.position")), prop.getProperty("UPKA2.name"),
					prop.getProperty("UPKA2.code")));
			thirsday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("secondSubject.startTime")),
					LocalTime.parse(prop.getProperty("secondSubject.endTime")),
					Integer.parseInt(prop.getProperty("secondSubject.position")), prop.getProperty("UPKA1.name"),
					prop.getProperty("UPKA1.code")));
			thirsday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("secondSubject.startTime")),
					LocalTime.parse(prop.getProperty("secondSubject.endTime")),
					Integer.parseInt(prop.getProperty("secondSubject.position")), prop.getProperty("UPKA2.name"),
					prop.getProperty("UPKA2.code")));
			thirsday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("thirthSubject.startTime")),
					LocalTime.parse(prop.getProperty("thirthSubject.endTime")),
					Integer.parseInt(prop.getProperty("thirthSubject.position")), prop.getProperty("BEL.name"),
					prop.getProperty("BEL.code")));
			thirsday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("fourthSubject.startTime")),
					LocalTime.parse(prop.getProperty("fourthSubject.endTime")),
					Integer.parseInt(prop.getProperty("fourthSubject.position")), prop.getProperty("BEL.name"),
					prop.getProperty("BEL.code")));
			thirsday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("fifthSubject.startTime")),
					LocalTime.parse(prop.getProperty("fifthSubject.endTime")),
					Integer.parseInt(prop.getProperty("fifthSubject.position")), prop.getProperty("UPZPU1.name"),
					prop.getProperty("UPZPU1.code")));
			thirsday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("fifthSubject.startTime")),
					LocalTime.parse(prop.getProperty("fifthSubject.endTime")),
					Integer.parseInt(prop.getProperty("fifthSubject.position")), prop.getProperty("UPZPU2.name"),
					prop.getProperty("UPZPU2.code")));
			thirsday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("sixthSubject.startTime")),
					LocalTime.parse(prop.getProperty("sixthSubject.endTime")),
					Integer.parseInt(prop.getProperty("sixthSubject.position")), prop.getProperty("UPZPU1.name"),
					prop.getProperty("UPZPU1.code")));
			thirsday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("sixthSubject.startTime")),
					LocalTime.parse(prop.getProperty("sixthSubject.endTime")),
					Integer.parseInt(prop.getProperty("sixthSubject.position")), prop.getProperty("UPZPU2.name"),
					prop.getProperty("UPZPU2.code")));
			thirsday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("seventhSubject.startTime")),
					LocalTime.parse(prop.getProperty("seventhSubject.endTime")),
					Integer.parseInt(prop.getProperty("seventhSubject.position")), prop.getProperty("ChKR.name"),
					prop.getProperty("ChKR.code")));
			thirsday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("eightSubject.startTime")),
					LocalTime.parse(prop.getProperty("eightSubject.endTime")),
					Integer.parseInt(prop.getProperty("eightSubject.position")), prop.getProperty("SD.name"),
					prop.getProperty("SD.code")));

			schoolSchedule.put(5, wendesday);

			wendesday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("secondSubject.startTime")),
					LocalTime.parse(prop.getProperty("secondSubject.endTime")),
					Integer.parseInt(prop.getProperty("secondSubject.position")), prop.getProperty("MAT.name"),
					prop.getProperty("MAT.code")));
			wendesday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("thirthSubject.startTime")),
					LocalTime.parse(prop.getProperty("thirthSubject.endTime")),
					Integer.parseInt(prop.getProperty("thirthSubject.position")), prop.getProperty("MAT.name"),
					prop.getProperty("MAT.code")));
			wendesday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("fourthSubject.startTime")),
					LocalTime.parse(prop.getProperty("fourthSubject.endTime")),
					Integer.parseInt(prop.getProperty("fourthSubject.position")), prop.getProperty("PROG.name"),
					prop.getProperty("PROG.code")));
			wendesday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("fifthSubject.startTime")),
					LocalTime.parse(prop.getProperty("fifthSubject.endTime")),
					Integer.parseInt(prop.getProperty("fifthSubject.position")), prop.getProperty("PROG.name"),
					prop.getProperty("PROG.code")));
			wendesday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("sixthSubject.startTime")),
					LocalTime.parse(prop.getProperty("sixthSubject.endTime")),
					Integer.parseInt(prop.getProperty("sixthSubject.position")), prop.getProperty("FVS.name"),
					prop.getProperty("FVS.code")));
			wendesday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("seventhSubject.startTime")),
					LocalTime.parse(prop.getProperty("seventhSubject.endTime")),
					Integer.parseInt(prop.getProperty("seventhSubject.position")), prop.getProperty("FVS.name"),
					prop.getProperty("FVS.code")));

			schoolSchedule.put(6, friday);

			friday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("thirthSubject.startTime")),
					LocalTime.parse(prop.getProperty("thirthSubject.endTime")),
					Integer.parseInt(prop.getProperty("thirthSubject.position")), prop.getProperty("UPKA1.name"),
					prop.getProperty("UPKA1.code")));
			friday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("thirthSubject.startTime")),
					LocalTime.parse(prop.getProperty("thirthSubject.endTime")),
					Integer.parseInt(prop.getProperty("thirthSubject.position")), prop.getProperty("UPKA2.name"),
					prop.getProperty("UPKA2.code")));
			friday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("fourthSubject.startTime")),
					LocalTime.parse(prop.getProperty("fourthSubject.endTime")),
					Integer.parseInt(prop.getProperty("fourthSubject.position")), prop.getProperty("UPKA1.name"),
					prop.getProperty("UPKA1.code")));
			friday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("fourthSubject.startTime")),
					LocalTime.parse(prop.getProperty("fourthSubject.endTime")),
					Integer.parseInt(prop.getProperty("fourthSubject.position")), prop.getProperty("UPKA2.name"),
					prop.getProperty("UPKA2.code")));
			friday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("fifthSubject.startTime")),
					LocalTime.parse(prop.getProperty("fifthSubject.endTime")),
					Integer.parseInt(prop.getProperty("fifthSubject.position")), prop.getProperty("KA.name"),
					prop.getProperty("KA.code")));
			friday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("sixthSubject.startTime")),
					LocalTime.parse(prop.getProperty("sixthSubject.endTime")),
					Integer.parseInt(prop.getProperty("sixthSubject.position")), prop.getProperty("KA.name"),
					prop.getProperty("KA.code")));
			friday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("seventhSubject.startTime")),
					LocalTime.parse(prop.getProperty("seventhSubject.endTime")),
					Integer.parseInt(prop.getProperty("seventhSubject.position")), prop.getProperty("ChEP.name"),
					prop.getProperty("ChEP.code")));
			friday.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("eightSubject.startTime")),
					LocalTime.parse(prop.getProperty("eightSubject.endTime")),
					Integer.parseInt(prop.getProperty("eightSubject.position")), prop.getProperty("ChEP.name"),
					prop.getProperty("ChEP.code")));

		} catch (Exception e) {
			System.out.println("[CraftCN schedule] Exception: " + e);
		}
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public List<String> getScheduledTasksLog() {
		return scheduledTasksLog;
	}

	public void scheduleTasks(GuildMessageReceivedEvent event) throws ParseException, IOException {

		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDate startDate = LocalDate.now();

		System.out.println("CraftCN " + "Server: " + event.getGuild() + " End-Date: " + getEndDate() + " Scheduler: "
				+ event.getMember().getUser() + " | " + LocalTime.now().format(dtf));

		for (LocalDate date = startDate; date.isBefore(getEndDate()); date = date.plusDays(1)) {

			if (LocalTime.now().getHour() > 12 && LocalDate.now().isEqual(date))
				continue;

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

					timer.schedule(new Notify(event, subject), scheduledTime);

					this.getScheduledTasksLog().add(logMessage(subject, scheduledTime, false));

					System.out.println(logMessage(subject, scheduledTime, true));
				}
			}
		}
	}

	private String logMessage(Subject subject, Date scheduledTime, boolean inSystem) {

		int max = 999999999;
		int min = 987654321;
		int accessToken = (int) (Math.random() * (max - min + 1) + min);

		if (inSystem)
			return "CraftCN " + accessToken + "-accessToken " + "| Task Time: " + scheduledTime + " | Subject: "
					+ subject.getName() + " | " + subject.getCode() + " - " + subject.getLocation() + " ["
					+ subject.getPosition() + "]";

		else
			return "**CraftCN** ||" + accessToken + "-accessToken|| " + "**Task Time:** `" + scheduledTime
					+ "` **Subject:** `" + subject.getName() + "`** | `" + subject.getLocation() + "` - ||"
					+ subject.getCode() + "|| [" + subject.getPosition() + "]**";
	}
}
