package com.appnull.commands.notifications.base;

import java.time.LocalTime;

public class SubjectImpl implements Subject {

	private SubjectTime subjectTime;
	private SubjectLocation subjectLocation;
	private SubjectName subjectName;

	private SubjectName subjectCode;
	private SubjectTime subjectPosition;
	private SubjectTime subjectEndTime;
	private SubjectTime subjectNextTime;

	public SubjectImpl(SubjectTime time, SubjectLocation location, SubjectName name) {
		this.subjectName = name;
		this.subjectLocation = location;
		this.subjectTime = time;

		this.subjectCode = name;
		this.subjectPosition = time;
		this.subjectEndTime = time;
		this.subjectNextTime = time;
	}

	@Override
	public LocalTime getStartTime() {
		return subjectTime.getStartTime();
	}

	@Override
	public String getName() {
		return subjectName.getName();
	}

	@Override
	public String getLocation() {
		return subjectLocation.getLocation();
	}

	@Override
	public String getPosition() {
		return subjectPosition.getPosition();
	}

	@Override
	public String getEndTime() {
		return subjectEndTime.getEndTime();
	}

	@Override
	public String getCode() {
		return subjectCode.getCode();
	}

	@Override
	public String getNextTime() {
		return subjectNextTime.getNextTime();
	}
}
