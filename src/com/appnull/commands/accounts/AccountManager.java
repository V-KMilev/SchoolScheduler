package com.appnull.commands.accounts;

public class AccountManager implements Account {

	private AccountName accountName;
	private AccountPassword accountPassword;
	
	public AccountManager(AccountName name, AccountPassword password) {
		this.accountName = name;
		this.accountPassword = password;
	}
	
	@Override
	public String getName() {
		return accountName.getName();
	}
	
	@Override
	public String getPassword() {
		return accountPassword.getPassword();
	}
}
