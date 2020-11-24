package com.appnull.commands.notifications.subjects;

import com.appnull.commands.notifications.base.SubjectName;

public class Mat implements SubjectName {

	@Override
	public String getName() {
		return "Математика";
	}

	@Override
	public String getCode() {
		return "fcs8b64";
	}
}
