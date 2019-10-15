package com.perscholas.sba01;

import java.util.Scanner;

/* Create a main class and request user input to print out to the console. 
 * You may choose any phrase to print out.*/

public class JavaSBAProject_01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter something to print out to the counsole :: ");
		String userInput = scan.nextLine();
		
		System.out.println();
		System.out.println("Your Input:");
		System.out.println(userInput);
		
		scan.close();
	}
}
