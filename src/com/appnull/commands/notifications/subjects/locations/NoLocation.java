package com.appnull.commands.notifications.subjects.locations;

import com.appnull.commands.notifications.base.SubjectLocation;

public class NoLocation implements SubjectLocation {

	@Override
	public String getLocation() {
		return "[NULL]";
	}

}