package com.appnull.commands.notifications.subjects;

import com.appnull.commands.notifications.base.SubjectCode;
import com.appnull.commands.notifications.base.SubjectName;

public class NE implements SubjectName, SubjectCode {

	@Override
	public String getName() {
		return "������ ���� (��)";
	}

	@Override
	public String getCode() {
		return "r3g6lg3";
	}
}
