package com.musicplayer.main;
import java.util.Scanner;
public class MainOperations {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Music Player");
		
		System.out.println("\nPlease Create an Account/Login to proceed");
		UserPage.accountCreate();
		
		System.out.println("Please Enter the required details to login");
		boolean log = false;
		int attempts = 1;
		
		while(!log && attempts<=3) {
			log = UserPage.accountLogin();
			if(log) {
				UserPage.homePage();
			} else {
				attempts++;
				if(attempts>3) {
					System.err.println("Limit Reached");
				}
			}
		}
	}
}