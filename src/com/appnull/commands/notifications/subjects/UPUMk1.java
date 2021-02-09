package com.appnull.commands.notifications.subjects;

import com.appnull.commands.notifications.base.SubjectCode;
import com.appnull.commands.notifications.base.SubjectName;

public class UPUMk1 implements SubjectName, SubjectCode {

	@Override
	public String getName() {
		return "Управление на микроконтролер (УП УМк-1) ПРАКТИКА, гр.1";
	}

	@Override
	public String getShortName() {
		return getName().substring(getName().indexOf('(') + 1, getName().indexOf(')'));
	}

	@Override
	public String getCode() {
		return "gyix9kd";
	}
}
