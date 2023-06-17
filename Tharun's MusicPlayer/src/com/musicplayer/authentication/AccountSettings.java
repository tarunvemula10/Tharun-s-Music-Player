package com.musicplayer.authentication;

public interface AccountSettings {
	
	public void createAccount(String emailId, String userName, String passcode, PersonalDetails pd);
	public boolean login(String email, String password, PersonalDetails pd);
	public void logout();
	public void changePasscode(String oldPasscode, String newPasscode, PersonalDetails pd);
	public void changeEmailId(String passcode, String newEmailId, PersonalDetails pd);
	
}