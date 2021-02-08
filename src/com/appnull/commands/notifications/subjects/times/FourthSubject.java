package com.appnull.commands.notifications.subjects.times;

import java.time.LocalTime;

import com.appnull.commands.notifications.base.SubjectEndTime;
import com.appnull.commands.notifications.base.SubjectNextTime;
import com.appnull.commands.notifications.base.SubjectPosition;
import com.appnull.commands.notifications.base.SubjectStartTime;

public class FourthSubject implements SubjectStartTime, SubjectEndTime, SubjectNextTime, SubjectPosition {

	@Override
	public LocalTime getStartTime() {
		return LocalTime.parse("15:00");
	}

	@Override
	public String getEndTime() {
		return "15:40";
	}

	@Override
	public String getNextTime() {
		return "15:50";
	}

	@Override
	public String getPosition() {
		return "4";
	}
}
