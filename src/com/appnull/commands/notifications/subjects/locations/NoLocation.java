package com.appnull.commands.notifications.subjects.locations;

import com.appnull.commands.notifications.SubjectLocation;

public class NoLocation implements SubjectLocation {

	@Override
	public String getLocation() {
		return "[NULL]";
	}

}