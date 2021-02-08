package com.appnull.commands.notifications.subjects;

import com.appnull.commands.notifications.base.SubjectCode;
import com.appnull.commands.notifications.base.SubjectName;

public class ChKR implements SubjectName, SubjectCode {

	@Override
	public String getName() {
		return "Час на класния ръководител (ЧКР)";
	}

	@Override
	public String getCode() {
		return "vva8xiv";
	}
}
