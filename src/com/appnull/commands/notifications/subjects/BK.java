package com.appnull.commands.notifications.subjects;

import com.appnull.commands.notifications.base.SubjectCode;
import com.appnull.commands.notifications.base.SubjectName;

public class BK implements SubjectName, SubjectCode {

	@Override
	public String getName() {
		return "Бизнес комуникации (БК)";
	}

	@Override
	public String getCode() {
		return "[NULL]";
	}
}
