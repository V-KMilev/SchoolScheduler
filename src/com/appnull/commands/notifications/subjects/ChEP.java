package com.appnull.commands.notifications.subjects;

import com.appnull.commands.notifications.base.SubjectName;

public class ChEP implements SubjectName {

	@Override
	public String getName() {
		return "Чужд език по професия (ЧЕП)";
	}

	@Override
	public String getCode() {
		return "vva8xiv";
	}
}
