package com.appnull.commands.notifications.subjects.times;

import java.time.LocalTime;

import com.appnull.commands.notifications.SubjectTime;

public class FirstSubject implements SubjectTime {

	@Override
	public LocalTime getStartTime() {
		return LocalTime.parse("07:30");
	}
}
