package com.appnull.commands.notifications.subjects;

import com.appnull.commands.notifications.base.SubjectName;

public class GO implements SubjectName {

	@Override
	public String getName() {
		return "Гражданско образование (ГО)";
	}

	@Override
	public String getCode() {
		return "pkiaoay";
	}
}
