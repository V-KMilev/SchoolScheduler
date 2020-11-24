package com.appnull.commands.notifications.subjects;

import com.appnull.commands.notifications.base.SubjectName;

public class SD implements SubjectName {

	@Override
	public String getName() {
		return "Спортни дейности (СД) | (ФВС)";
	}

	@Override
	public String getCode() {
		return "mcsehdp";
	}
}
