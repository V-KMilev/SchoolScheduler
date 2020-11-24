package com.appnull.commands.notifications.subjects.times;

import java.time.LocalTime;

import com.appnull.commands.notifications.base.SubjectTime;

public class NinthSubject implements SubjectTime {

	@Override
	public LocalTime getStartTime() {
		return LocalTime.parse("14:40");
	}

	@Override
	public String getEndTime() {
		return "15:20";
	}

	@Override
	public String getNextTime() {
		return "END - [NULL]";
	}

	@Override
	public String getPosition() {
		return "9";
	}
}