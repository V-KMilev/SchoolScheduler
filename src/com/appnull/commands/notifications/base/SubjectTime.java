package com.appnull.commands.notifications.base;

import java.time.LocalTime;

public interface SubjectTime {

	public LocalTime getStartTime();

	public String getEndTime();

	public String getPosition();

	public String getNextTime();
}
