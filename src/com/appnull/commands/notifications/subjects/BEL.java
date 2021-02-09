package com.appnull.commands.notifications.subjects;

import com.appnull.commands.notifications.base.SubjectCode;
import com.appnull.commands.notifications.base.SubjectName;

public class BEL implements SubjectName, SubjectCode {

	@Override
	public String getName() {
		return "��������� ���� � ���������� (���)";
	}

	@Override
	public String getShortName() {
		return getName().substring(getName().indexOf('(') + 1, getName().indexOf(')'));
	}

	@Override
	public String getCode() {
		return "b2x1o8k";
	}
}
