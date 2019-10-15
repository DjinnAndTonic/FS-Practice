package com.perscholas.sba04;

import java.util.Scanner;

/*Create a simple menu application with 4 options. Prompt 
 * the user to make a selection. Each option will print a 
 * string: “Good morning.”, “Good afternoon”,  
 * “Good evening” and “Good night”. If the user selects 
 * option 4 (“Good night.”) then the application will end.*/
public class JavaSBAProject_04 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int choice = -1;
		
		while(choice != 4) {
			try {
				System.out.println("\nTime of Day\n"
						+ "1. Morning\n"
						+ "2. Afternoon\n"
						+ "3. Evening\n"
						+ "4. Night");
				System.out.print("Selection: ");
				choice = scan.nextInt();
				
				switch(choice) {
				case 1:
					System.out.println("Good Morning.");
					break;
				case 2:
					System.out.println("Good Afternoon.");
					break;
				case 3:
					System.out.println("Good Evening.");
					break;
				case 4:
					System.out.println("Good Night.");
					break;
				default:
					System.out.println("Invalid Choice.");
				}
			} catch(Exception e) {
				System.out.println("Invalid input. Program terminating.");
				break;
			}
		}
		
		scan.close();
	}
}
