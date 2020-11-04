package com.appnull.commands.notifications.subjects.times;

import java.time.LocalTime;

import com.appnull.commands.notifications.SubjectTime;

public class FirstSubject implements SubjectTime {

	@Override
	public LocalTime getStartTime() {
		return LocalTime.parse("08:00");
	}

	@Override
	public String getEndTime() {
		return "08:40";
	}

	@Override
	public String getPosition() {
		return "1";
	}
}
