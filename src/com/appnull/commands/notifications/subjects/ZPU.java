package com.appnull.commands.notifications.subjects;

import com.appnull.commands.notifications.base.SubjectCode;
import com.appnull.commands.notifications.base.SubjectName;

public class ZPU implements SubjectName, SubjectCode {

	@Override
	public String getName() {
		return "Запаметяващи и периферни устройства (ЗПУ)";
	}

	@Override
	public String getShortName() {
		return getName().substring(getName().indexOf('(') + 1, getName().indexOf(')'));
	}

	@Override
	public String getCode() {
		return "3m9tmd5";
	}
}
