package com.appnull.subject;

import java.time.LocalTime;

public class SubjectImpl implements Subject {

	private LocalTime startTime;
	private LocalTime endTime;

	private String name;
	private String code;
	private String location;

	private int position;

	public SubjectImpl(String location, LocalTime startTime, LocalTime endTime, int position, String name,
			String code) {

		this.startTime = startTime;
		this.endTime = endTime;

		this.position = position;
		this.name = name;
		this.code = code;

		this.location = location;

	}

	@Override
	public LocalTime getStartTime() {
		return startTime;
	}

	@Override
	public LocalTime getEndTime() {
		return endTime;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getLocation() {
		return location;
	}

	@Override
	public int getPosition() {
		return position;
	}
}
