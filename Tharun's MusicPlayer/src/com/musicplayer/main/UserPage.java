package com.musicplayer.main;
import com.musicplayer.authentication.*;
import java.util.Scanner;
import com.musicplayer.operations.*;

public class UserPage {
	
	static Scanner sc = new Scanner(System.in);
	static PersonalDetails personalDetails = new PersonalDetails();
	
	public static String[] tracksList = 
		{">one", "dreams", "notion", "paradise", "starboy", "peaches", "infinity", "fantasy"};
	
	public static boolean accountLogin() {
		
		//Details for logging in into the account
		System.out.print("Enter the Email Id : ");
		String email = sc.next();
		
		System.out.print("Enter the Password : ");
		String passcode = sc.next();
		
		return LoginDetails.getInstance().login(email, passcode, personalDetails);
		
	}
	
	public static void accountCreate() {
		
		//Giving required details for creating an account
		System.out.print("Enter the emailId : ");
		String emailId = sc.next();
		
		System.out.print("Enter the User Name : ");
		String userName = sc.next();
		
		System.out.print("Enter the password : ");
		String password = sc.next();
		
		LoginDetails.getInstance().createAccount(emailId, userName, password, personalDetails);
		
	}
	
	public static void homePage() {
		
		System.out.println("1 to Play single track"
							+ "\n2 to play all tracks"
							+ "\n3 to go to search page"
							+ "\n4 to go to settings pages"
							+ "\n0 to close application");
		
		System.out.println("\nSelect an option");
		int option = sc.nextInt();
		switch(option) {
		case 1:
			/*
			 * to play the single track, 
			 * if there's a song with a specific name in the list then the song plays
			 */
			System.out.print("Enter any Song to play : ");
			SearchPage.getInstance().searchSong(tracksList ,sc.next());
			homePage();
			break;
		case 2:
			//plays every single track from the list
			HomePage.getInstance().playAllTracks(tracksList);
			homePage();
			break;
		case 3:
			//directs to search page
			System.out.println("You are now in search page");
			searchPage();
			break;
		case 4:
			//directs to settings page
			System.out.println("You are now in settings page");
			settingsPage();
			break;
		case 0:
			System.out.println("Application Closed");
			break;
		default :
			System.err.println("Error!, Please enter a valid option");
			homePage();
			break;
		}
	}
	public static void searchPage() {
		System.out.println("1 to Search Song"
							+ "\n2 to Home page"
							+ "\n3 to settings page"
							+ "\n0 to close application");
		
		System.out.print("\nEnter any option : ");
		int option = sc.nextInt();
		
		switch(option) {
		case 1:
			//to search for the song and play
			System.out.print("Enter a song to search : ");
			SearchPage.getInstance().searchSong(tracksList ,sc.next());
			searchPage();
			break;
		case 2:
			//to direct to home page
			System.out.println("You are now in Home Page");
			homePage();
			break;
		case 3:
			//to direct to settings page
			System.out.println("You are now in Settings Page");
			settingsPage();
			break;
		case 0:
			System.out.println("Application Closed");
			break;
		default:
			System.err.println("Error!, Plaese enter a valid option");
			searchPage();
			break;
		}
	}
	
	public static void settingsPage() {
		
		System.out.println("1 to Change Email"
							+ "\n2 to Change Password"
							+ "\n3 to Home Page"
							+ "\n4 to Search page"
							+ "\n5 to logout");
		
		System.out.print("\nEnter any option : ");
		int option = sc.nextInt();
		
		switch(option) {
		case 1:
			
			//taking details for changing email address
			System.out.print("Enter the password : ");
			String password = sc.next();
			System.out.print("Enter the new Email Id : ");
			String email = sc.next();
			
			LoginDetails.getInstance().changeEmailId(password, email, personalDetails);
			LoginDetails.getInstance().logout(); //logging out of account after modifying details
			accountLogin();
			homePage();
			break;
		case 2:
			
			//taking details to change password
			System.out.print("Enter the old password : ");
			String oldPassword = sc.next();
			System.out.print("Enter the new password : ");
			String newPassword = sc.next();
			
			LoginDetails.getInstance().changePasscode(oldPassword, newPassword, personalDetails);
			LoginDetails.getInstance().logout(); //logging out of account after modifying details
			accountLogin();
			homePage();
			break;
		case 3:
			//directing to home page
			System.out.println("You are in Home Page");
			homePage();
			break;
		case 4:
			//directing to settings page
			System.out.println("You are in settings page");
			settingsPage();
			break;
		case 5:
			//for logging in again
			LoginDetails.getInstance().logout();
			loginOperations();
			homePage();
			break;
		case 0:
			//for creating an account
			System.out.println("Application Closed");
			break;
		default:
			System.err.println("Error!, Plaese enter a valid option");
			settingsPage();
			break;
		}
	}
	
	//writing create account and login functions in one fuction
	public static void loginOperations() {
		System.out.println("Enter 1 to login"
							+ "\nEnter 2 to create account");
		switch(sc.nextInt()) {
		case 1 :
			accountLogin();
			break;
		case 2:
			accountCreate();
			accountLogin();
			break;
		case 0 :
			System.out.println("Closed Application");
			break;
		default:
			System.err.println("Error!, Plaese enter a valid option");
			loginOperations();
			break;
		}
	}
}