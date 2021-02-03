package com.appnull.commands.notifications.subjects.times;

import java.time.LocalTime;

import com.appnull.commands.notifications.base.SubjectTime;

public class EighthSubject implements SubjectTime {

	@Override
	public LocalTime getStartTime() {
		return LocalTime.parse("18:20");
	}

	@Override
	public String getEndTime() {
		return "19:00";
	}

	@Override
	public String getNextTime() {
		return "END - [NULL]";
	}

	@Override
	public String getPosition() {
		return "8";
	}
}