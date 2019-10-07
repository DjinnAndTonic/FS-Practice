package com.perscholas.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexRunner {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String username, password;
		
		System.out.print("Enter a username: ");
		username = scan.nextLine();
		System.out.print("Enter a password: ");
		password = scan.nextLine();
		
		System.out.println((validateUsername(username))? 
					username + " is a valid username." :
					username + " is NOT a valid username.");
		
		System.out.println((validatePassword(password))? 
					password + " is a valid password." :
					password + " is NOT a valid password.");
		scan.close();
	}
	
	public static boolean validateUsername(String user) {
		final String VALID_USER = "[\\S]{8}";
		Pattern pattern = Pattern.compile(VALID_USER);
		Matcher matcher = pattern.matcher(user);
		return matcher.matches();
	}
	
	public static boolean validatePassword(String pass) {
		final String VALID_PASS = "\\p{Alnum}{6}";
		Pattern pattern = Pattern.compile(VALID_PASS);
		Matcher matcher = pattern.matcher(pass);
		return matcher.matches();
	}
}
