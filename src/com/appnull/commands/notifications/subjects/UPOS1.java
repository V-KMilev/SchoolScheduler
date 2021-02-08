package com.appnull.commands.notifications.subjects;

import com.appnull.commands.notifications.base.SubjectCode;
import com.appnull.commands.notifications.base.SubjectName;

public class UPOS1 implements SubjectName, SubjectCode {

	@Override
	public String getName() {
		return "Операционни системи (ОС) ПРАКТИКА, гр.1";
	}

	@Override
	public String getCode() {
		return "6sgsil2";
	}
}
