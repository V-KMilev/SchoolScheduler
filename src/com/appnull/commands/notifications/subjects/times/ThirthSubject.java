package com.appnull.commands.notifications.subjects.times;

import java.time.LocalTime;

import com.appnull.commands.notifications.base.SubjectTime;

public class ThirthSubject implements SubjectTime {

	@Override
	public LocalTime getStartTime() {
		return LocalTime.parse("14:10");
	}

	@Override
	public String getEndTime() {
		return "14:50";
	}

	@Override
	public String getNextTime() {
		return "15:00";
	}

	@Override
	public String getPosition() {
		return "3";
	}
}
