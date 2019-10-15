package com.perscholas.sba02;

import java.util.Scanner;
/*Write a Java application that generates a random number and 
 * asks the user to guess the number within a range. If the 
 * user's guess is higher than the random number, the program 
 * should display "Too high, try again." If the user's guess is 
 * lower than the random number, the program should display "Too 
 * low, try again." The program should use a loop that repeats 
 * until the user correctly guesses the random number. * 
 * */
public class JavaSBAProject_02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// generates a random number between 1 and 10		
		int rand = (int)(Math.random()*10) + 1;
		int userGuess = -1;
		
		System.out.println("Guess the number!");
		
		while(userGuess != rand) {
			try {
				System.out.print("Enter a value between 1 and 10 and see if you are correct: ");
				userGuess = scan.nextInt();
				
				if(userGuess > rand)
					System.out.println("Too high, try again.");
				else if(userGuess < rand)
					System.out.println("Too low, try again.");
				else {
					System.out.println("Correct! The random number was " + rand);
				}
				
			} catch(Exception e) {
				System.out.println("Invalid input. Please enter an integer between 1 and 10.");
			}
		}
		
		scan.close();
	}
}
