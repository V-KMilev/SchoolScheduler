package com.appnull.commands.notifications.subjects;

import com.appnull.commands.notifications.base.SubjectCode;
import com.appnull.commands.notifications.base.SubjectName;

public class FVS implements SubjectName, SubjectCode {

	@Override
	public String getName() {
		return "Физическо възпитание и спорт (ФВС)";
	}

	@Override
	public String getCode() {
		return "mcsehdp";
	}
}
