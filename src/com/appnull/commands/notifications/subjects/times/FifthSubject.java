package com.appnull.commands.notifications.subjects.times;

import java.time.LocalTime;

import com.appnull.commands.notifications.SubjectTime;

public class FifthSubject implements SubjectTime {

	@Override
	public LocalTime getStartTime() {
		return LocalTime.parse("11:20");
	}

	@Override
	public String getEndTime() {
		return "12:00";
	}

	@Override
	public String getPosition() {
		return "5";
	}
}
