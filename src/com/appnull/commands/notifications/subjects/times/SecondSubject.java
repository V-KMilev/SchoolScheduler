package com.appnull.commands.notifications.subjects.times;

import java.time.LocalTime;

import com.appnull.commands.notifications.base.SubjectTime;

public class SecondSubject implements SubjectTime {

	@Override
	public LocalTime getStartTime() {

		return LocalTime.parse("13:20");
	}

	@Override
	public String getEndTime() {
		return "14:00";
	}

	@Override
	public String getNextTime() {
		return "14:10";
	}

	@Override
	public String getPosition() {
		return "2";
	}
}
