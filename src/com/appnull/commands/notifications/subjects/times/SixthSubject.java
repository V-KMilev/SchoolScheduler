package com.appnull.commands.notifications.subjects.times;

import java.time.LocalTime;

import com.appnull.commands.notifications.base.SubjectEndTime;
import com.appnull.commands.notifications.base.SubjectNextTime;
import com.appnull.commands.notifications.base.SubjectPosition;
import com.appnull.commands.notifications.base.SubjectStartTime;

public class SixthSubject implements SubjectStartTime, SubjectEndTime, SubjectNextTime, SubjectPosition {

	@Override
	public LocalTime getStartTime() {
		return LocalTime.parse("16:40");
	}

	@Override
	public String getEndTime() {
		return "17:20";
	}

	@Override
	public String getNextTime() {
		return "17:40";
	}

	@Override
	public String getPosition() {
		return "6";
	}
}
