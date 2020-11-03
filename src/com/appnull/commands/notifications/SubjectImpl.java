package com.appnull.commands.notifications;

import java.time.LocalTime;

public class SubjectImpl implements Subject {

	private SubjectTime subjectTime;
	private SubjectLocation subjectLocation;
	private SubjectName subjectName;
	private SubjectTime subjectPosition;

	public SubjectImpl(SubjectTime time, SubjectLocation location, SubjectName name) {
		this.subjectName = name;
		this.subjectLocation = location;
		this.subjectTime = time;
		this.subjectPosition = time;
	}

	@Override
	public LocalTime getStartTime() {
		return subjectTime.getStartTime();
	}

	@Override
	public String getPosition() {
		return subjectPosition.getPosition();
	}

	@Override
	public String getName() {
		return subjectName.getName();
	}

	@Override
	public String getLocation() {
		return subjectLocation.getLocation();
	}
}
