package com.appnull.commands.notifications.subjects;

import com.appnull.commands.notifications.base.SubjectCode;
import com.appnull.commands.notifications.base.SubjectName;

public class BEL implements SubjectName, SubjectCode {

	@Override
	public String getName() {
		return "Български език и литература (БЕЛ)";
	}

	@Override
	public String getCode() {
		return "b2x1o8k";
	}
}
