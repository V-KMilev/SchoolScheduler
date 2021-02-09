package com.appnull.commands.notifications.base;

import java.time.LocalTime;

public class SubjectImpl implements Subject {

	private SubjectStartTime subjectStartTime;
	private SubjectLocation subjectLocation;
	private SubjectName subjectName;
	private SubjectName subjectShortName;

	private SubjectEndTime subjectEndTime;
	private SubjectNextTime subjectNextTime;
	private SubjectPosition subjectPosition;
	private SubjectCode subjectCode;

	public SubjectImpl(SubjectStartTime startTime, SubjectLocation location, SubjectName name) {

		this.subjectName = name;
		this.subjectShortName = name;
		this.subjectLocation = location;
		this.subjectStartTime = startTime;

		this.subjectEndTime = (SubjectEndTime) startTime;
		this.subjectNextTime = (SubjectNextTime) startTime;
		this.subjectPosition = (SubjectPosition) startTime;
		this.subjectCode = (SubjectCode) name;
	}

	@Override
	public LocalTime getStartTime() {
		return subjectStartTime.getStartTime();
	}

	@Override
	public String getLocation() {
		return subjectLocation.getLocation();
	}

	@Override
	public String getName() {
		return subjectName.getName();
	}
	
	@Override
	public String getShortName() {
		return subjectShortName.getShortName();
	}

	@Override
	public String getEndTime() {
		return subjectEndTime.getEndTime();
	}

	@Override
	public String getNextTime() {
		return subjectNextTime.getNextTime();
	}

	@Override
	public String getPosition() {
		return subjectPosition.getPosition();
	}

	@Override
	public String getCode() {
		return subjectCode.getCode();
	}

}
