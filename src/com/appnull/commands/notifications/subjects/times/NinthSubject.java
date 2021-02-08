package com.appnull.commands.notifications.subjects.times;

import java.time.LocalTime;

import com.appnull.commands.notifications.base.SubjectEndTime;
import com.appnull.commands.notifications.base.SubjectNextTime;
import com.appnull.commands.notifications.base.SubjectPosition;
import com.appnull.commands.notifications.base.SubjectStartTime;

public class NinthSubject implements SubjectStartTime, SubjectEndTime, SubjectNextTime, SubjectPosition {

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