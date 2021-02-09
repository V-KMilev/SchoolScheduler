package com.appnull.commands.notifications.subjects;

import com.appnull.commands.notifications.base.SubjectCode;
import com.appnull.commands.notifications.base.SubjectName;

public class GO implements SubjectName, SubjectCode {

	@Override
	public String getName() {
		return "Гражданско образование (ГО)";
	}

	@Override
	public String getShortName() {
		return getName().substring(getName().indexOf('(') + 1, getName().indexOf(')'));
	}

	@Override
	public String getCode() {
		return "5doin5h";
	}
}
