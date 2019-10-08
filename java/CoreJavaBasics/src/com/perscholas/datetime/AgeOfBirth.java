package com.perscholas.datetime;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class AgeOfBirth {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");
		
		System.out.print("Enter your date of birth (MM/DD/YYYY): ");
		String dobString = scan.nextLine();
		
		try {
			LocalDate dob = LocalDate.parse(dobString, dtf);
			
			System.out.println("You are " + 
					Period.between(dob, LocalDate.now()).getYears() +
					" years old!");
		} catch(Exception e) {
			System.out.println("Invalid Date!");
		}
		
		scan.close();
	}
}
