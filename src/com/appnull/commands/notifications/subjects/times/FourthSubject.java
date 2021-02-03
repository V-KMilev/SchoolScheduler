package com.appnull.commands.notifications.subjects.times;

import java.time.LocalTime;

import com.appnull.commands.notifications.base.SubjectTime;

public class FourthSubject implements SubjectTime {

	@Override
	public LocalTime getStartTime() {
		return LocalTime.parse("15:00");
	}

	@Override
	public String getEndTime() {
		return "15:40";
	}

	@Override
	public String getNextTime() {
		return "15:50";
	}

	@Override
	public String getPosition() {
		return "4";
	}
}
