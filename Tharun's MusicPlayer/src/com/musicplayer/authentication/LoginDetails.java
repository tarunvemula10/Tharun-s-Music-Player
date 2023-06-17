package com.musicplayer.authentication;

public class LoginDetails implements AccountSettings {
	
	private LoginDetails() { }
	private static LoginDetails instance = null;
	
	@Override
	public void createAccount(String emailId, String userName, String passcode, PersonalDetails pd) {
		//To set Email
		pd.setEmailId(emailId);
		
		//To set user name
		pd.setUserName(userName);
		
		//To set password
		pd.setPassword(passcode);
		
		System.out.println("Account Created!");
	}

	@Override
	public boolean login(String email, String password, PersonalDetails pd) {
		
		//checks if the details entered are matching with the actual ones
		if(email.equals(pd.getEmailId()) && password.equals(pd.getPassword())) {
			System.out.println("Welcome, "+pd.getUserName());
			return true;
		} else {
			System.out.println("Invalid Details, Try again....");
		}
		return false;
	}

	@Override
	public void logout() {
		System.out.println("Logged out successfully");
	}

	@Override
	public void changePasscode(String oldPasscode, String newPasscode, PersonalDetails pd) {
		
		// checks with the old password and makes changes accordingly to the password
		if(oldPasscode.equals(pd.getPassword())) {
			pd.setPassword(newPasscode);
		} else {
			System.err.println("Error!, Enter the valid Password");
		}
	}

	@Override
	public void changeEmailId(String passcode, String newEmailId, PersonalDetails pd) {
		
		//checks with the old passcode and makes the changes accordingly to email
		if(passcode.equals(pd.getPassword())) {
			pd.setEmailId(newEmailId);
		} else {
			System.err.println("Error!, Please Enter the Valid Password");
		}
	}
	
	//singleton class
	public static LoginDetails getInstance() {
		if(instance==null) {
			return new LoginDetails();
		}
		return instance;
	}
}