package com.appnull.commands.notifications.subjects;

import com.appnull.commands.notifications.base.SubjectCode;
import com.appnull.commands.notifications.base.SubjectName;

public class PROG implements SubjectName, SubjectCode {

	@Override
	public String getName() {
		return "Програмиране";
	}

	@Override
	public String getCode() {
		return "gyix9kd";
	}
}
