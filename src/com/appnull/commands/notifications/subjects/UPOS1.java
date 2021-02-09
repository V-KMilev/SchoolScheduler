package com.appnull.commands.notifications.subjects;

import com.appnull.commands.notifications.base.SubjectCode;
import com.appnull.commands.notifications.base.SubjectName;

public class UPOS1 implements SubjectName, SubjectCode {

	@Override
	public String getName() {
		return "Операционни системи (УП ОС-1) ПРАКТИКА, гр.1";
	}

	@Override
	public String getShortName() {
		return getName().substring(getName().indexOf('(') + 1, getName().indexOf(')'));
	}

	@Override
	public String getCode() {
		return "6sgsil2";
	}
}
