package com.appnull.commands.notifications.subjects.times;

import java.time.LocalTime;

import com.appnull.commands.notifications.SubjectTime;

public class FourthSubject implements SubjectTime {

	@Override
	public LocalTime getStartTime() {
		return LocalTime.parse("10:30");
	}
	
	@Override
	public String getPosition() {
		return "4";
	}
}
