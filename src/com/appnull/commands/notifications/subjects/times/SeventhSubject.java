package com.appnull.commands.notifications.subjects.times;

import java.time.LocalTime;

import com.appnull.commands.notifications.base.SubjectTime;

public class SeventhSubject implements SubjectTime {

	@Override
	public LocalTime getStartTime() {
		return LocalTime.parse("13:00");
	}

	@Override
	public String getEndTime() {
		return "13:40";
	}

	@Override
	public String getNextTime() {
		return "13:50";
	}

	@Override
	public String getPosition() {
		return "7";
	}
}
