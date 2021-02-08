package com.appnull.commands.notifications.subjects;

import com.appnull.commands.notifications.base.SubjectCode;
import com.appnull.commands.notifications.base.SubjectName;

public class MAT implements SubjectName, SubjectCode {

	@Override
	public String getName() {
		return "Математика";
	}

	@Override
	public String getCode() {
		return "fcs8b64";
	}
}
