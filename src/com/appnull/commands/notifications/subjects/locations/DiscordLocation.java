package com.appnull.commands.notifications.subjects.locations;

import com.appnull.commands.notifications.SubjectLocation;

public class DiscordLocation implements SubjectLocation {

	@Override
	public String getLocation() {
		return "Discord";
	}

}
