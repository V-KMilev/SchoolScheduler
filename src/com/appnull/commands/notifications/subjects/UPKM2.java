package com.appnull.commands.notifications.subjects;

import com.appnull.commands.notifications.base.SubjectCode;
import com.appnull.commands.notifications.base.SubjectName;

public class UPKM2 implements SubjectName, SubjectCode {

	@Override
	public String getName() {
		return "���������� ����� (�� ��-2) ��������, ��.2";
	}

	@Override
	public String getShortName() {
		return getName().substring(getName().indexOf('(') + 1, getName().indexOf(')'));
	}

	@Override
	public String getCode() {
		return "1l74fza";
	}
}
