package com.appnull.commands.notifications.subjects.times;

import java.time.LocalTime;

import com.appnull.commands.notifications.base.SubjectTime;

public class FifthSubject implements SubjectTime {

	@Override
	public LocalTime getStartTime() {
		return LocalTime.parse("15:50");
	}

	@Override
	public String getEndTime() {
		return "16:30";
	}

	@Override
	public String getNextTime() {
		return "16:40";
	}

	@Override
	public String getPosition() {
		return "5";
	}
}
