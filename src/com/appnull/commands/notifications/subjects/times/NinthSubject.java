package com.appnull.commands.notifications.subjects.times;

import java.time.LocalTime;

import com.appnull.commands.notifications.base.SubjectTime;

public class NinthSubject implements SubjectTime {

	@Override
	public LocalTime getStartTime() {
		return LocalTime.parse("[NULL]");
	}

	@Override
	public String getEndTime() {
		return "[NULL]";
	}

	@Override
	public String getNextTime() {
		return "[NULL]";
	}

	@Override
	public String getPosition() {
		return "9";
	}
}