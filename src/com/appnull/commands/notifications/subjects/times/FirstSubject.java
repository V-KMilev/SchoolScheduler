package com.appnull.commands.notifications.subjects.times;

import java.time.LocalTime;

import com.appnull.commands.notifications.base.SubjectTime;

public class FirstSubject implements SubjectTime {

	@Override
	public LocalTime getStartTime() {
		return LocalTime.parse("12:30");
	}

	@Override
	public String getEndTime() {
		return "13:10";
	}

	@Override
	public String getNextTime() {
		return "13:20";
	}

	@Override
	public String getPosition() {
		return "1";
	}
}
