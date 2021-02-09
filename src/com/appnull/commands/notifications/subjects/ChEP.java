package com.appnull.commands.notifications.subjects;

import com.appnull.commands.notifications.base.SubjectCode;
import com.appnull.commands.notifications.base.SubjectName;

public class ChEP implements SubjectName, SubjectCode {

	@Override
	public String getName() {
		return "Чужд език по професия (ЧЕП)";
	}

	@Override
	public String getShortName() {
		return getName().substring(getName().indexOf('(') + 1, getName().indexOf(')'));
	}

	@Override
	public String getCode() {
		return "vva8xiv";
	}
}
