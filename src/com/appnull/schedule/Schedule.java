package com.appnull.schedule;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

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
	private final DateTimeFormatter formatter;
	private final LocalDate endDate;
	private final Calendar calendar;
	private final Timer timer;

	private final Properties prop = new Properties();
	private final String propFileTime = "time.properties";

	private InputStream inputStream;

	public Schedule() {

		this.formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		this.endDate = LocalDate.parse("30/03/2021 23:59:59", formatter);
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

			if (inputStream != null) {
				prop.load(inputStream);
			} else
				throw new FileNotFoundException("property file '" + inputStream + "' not found in the classpath!");

			schoolSchedule.put(2, mondays);

			mondays.add(new SubjectImpl(prop.getProperty("Teams"),
					LocalTime.parse(prop.getProperty("firstSubject.startTime")),
					LocalTime.parse(prop.getProperty("firstSubject.endTime")),
					Integer.parseInt(prop.getProperty("firstSubject.position")), prop.getProperty("BEL.name"),
					prop.getProperty("BEL.code")));

			schoolSchedule.put(3, tuesday);

			schoolSchedule.put(4, thirsday);

			schoolSchedule.put(5, wendesday);

			schoolSchedule.put(6, friday);

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
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

					int max = 999999999;
					int min = 987654321;
					int accessToken = (int) (Math.random() * (max - min + 1) + min);

					String logMessageSOUT = "CraftCN " + accessToken + "-accessToken " + "| Task Time: " + scheduledTime
							+ " | Subject: " + subject.getName() + " | " + subject.getCode() + " - "
							+ subject.getLocation() + " [" + subject.getPosition() + "]";

					String logMessageJDA = "**CraftCN** ||" + accessToken + "-accessToken|| " + "**Task Time:** `"
							+ scheduledTime + "` **Subject:** `" + subject.getName() + "`** | `" + subject.getLocation()
							+ "` - ||" + subject.getCode() + "|| [" + subject.getPosition() + "]**";

					this.getScheduledTasksLog().add(logMessageJDA);

					timer.schedule(new Notify(event, subject), scheduledTime);

					System.out.println(logMessageSOUT);
				}
			}
		}
	}
}
