package com.appnull.commands.notifications.subjects.times;

import java.time.LocalTime;

import com.appnull.commands.notifications.base.SubjectTime;

public class EighthSubject implements SubjectTime {

	@Override
	public LocalTime getStartTime() {
		return LocalTime.parse("13:50");
	}

	@Override
	public String getEndTime() {
		return "14:30";
	}
	
	@Override
	public String getNextTime() {
		return "14:40";
	}

	@Override
	public String getPosition() {
		return "8";
	}
}