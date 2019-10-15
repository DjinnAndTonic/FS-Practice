package com.perscholas.sba03;

import java.util.Scanner;

/* Create a main class and request user input to initialize the Course 
 * class. Print out the course toString method to display the user’s input.*/
public class JavaSBAProject_03 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Course c = new Course();
		try {
			System.out.print("Enter a course id (int): ");
			c.setId(scan.nextInt());
			scan.nextLine();
			System.out.print("Enter a course name: ");
			c.setName(scan.nextLine().trim());
			System.out.print("Enter a course description: ");
			c.setDescription(scan.nextLine().trim());
			
			System.out.println();
			System.out.println("Course created ::\n" + c);
		} catch(Exception e) {
			System.out.println("Invalid input.");
		}
		
		scan.close();
	}
}
