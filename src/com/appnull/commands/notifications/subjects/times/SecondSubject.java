package com.appnull.commands.notifications.subjects.times;

import java.time.LocalTime;

import com.appnull.commands.notifications.SubjectTime;

public class SecondSubject implements SubjectTime {

	@Override
	public LocalTime getStartTime() {
		
		return LocalTime.parse("00:01");
	}
}
