package com.appnull.commands.notifications.subjects;

import com.appnull.commands.notifications.base.SubjectCode;
import com.appnull.commands.notifications.base.SubjectName;

public class OS implements SubjectName, SubjectCode {

	@Override
	public String getName() {
		return "Операционни системи (ОС)";
	}

	@Override
	public String getCode() {
		return "6sgsil2";
	}
}
