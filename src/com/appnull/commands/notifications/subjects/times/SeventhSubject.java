package com.appnull.commands.notifications.subjects.times;

import java.time.LocalTime;

import com.appnull.commands.notifications.base.SubjectTime;

public class SeventhSubject implements SubjectTime {

	@Override
	public LocalTime getStartTime() {
		return LocalTime.parse("17:30");
	}

	@Override
	public String getEndTime() {
		return "18:10";
	}

	@Override
	public String getNextTime() {
		return "18:20";
	}

	@Override
	public String getPosition() {
		return "7";
	}
}
