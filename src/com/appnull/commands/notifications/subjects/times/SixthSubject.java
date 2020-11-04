package com.appnull.commands.notifications.subjects.times;

import java.time.LocalTime;

import com.appnull.commands.notifications.SubjectTime;

public class SixthSubject implements SubjectTime {

	@Override
	public LocalTime getStartTime() {
		return LocalTime.parse("12:10");
	}

	@Override
	public String getEndTime() {
		return "12:50";
	}

	@Override
	public String getPosition() {
		return "6";
	}
}
