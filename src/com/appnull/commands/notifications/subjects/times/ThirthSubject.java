package com.appnull.commands.notifications.subjects.times;

import java.time.LocalTime;

import com.appnull.commands.notifications.base.SubjectTime;

public class ThirthSubject implements SubjectTime {

	@Override
	public LocalTime getStartTime() {
		return LocalTime.parse("09:40");
	}

	@Override
	public String getEndTime() {
		return "10:20";
	}

	@Override
	public String getNextTime() {
		return "10:30";
	}

	@Override
	public String getPosition() {
		return "3";
	}
}
