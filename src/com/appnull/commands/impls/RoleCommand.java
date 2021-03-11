package com.appnull.commands.impls;

import com.appnull.commands.managers.RoleManager;

public abstract class RoleCommand {

	protected RoleManager roleManager = new RoleManager();
	
	protected String role = "tester";

}
