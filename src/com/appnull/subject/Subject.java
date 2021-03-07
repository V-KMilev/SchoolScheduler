package com.appnull.subject;

import java.time.LocalTime;

public interface Subject {

	public LocalTime getStartTime();

	public LocalTime getEndTime();

	public String getName();

	public String getCode();

	public String getLocation();

	public int getPosition();
}
