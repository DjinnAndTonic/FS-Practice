package com.perscholas.sba05;

import java.util.ArrayList;
import java.util.Scanner;

/*Create an application that includes a menu to 
 * add or remove strings to a list and a menu item 
 * that displays the list and a final menu item to quit.*/
public class JavaSBAProject_05 {
	private static ArrayList<String> strList = new ArrayList<String>();
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int choice = -1;
		
		while(choice != 4) {
			try {
				System.out.println("\nList of Strings\n"
						+ "1. Add String to list\n"
						+ "2. Remove String from list\n"
						+ "3. Display List\n"
						+ "4. Quit");
				System.out.print("Selection: ");
				choice = scan.nextInt();
				scan.nextLine();
				
				switch(choice) {
				case 1:
					addToList(scan);
					break;
				case 2:
					removeFromList(scan);
					break;
				case 3:
					displayList();
					break;
				case 4:
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
	
	public static void addToList(Scanner scan) {
		System.out.println("Enter a String to add to the list:");
		String tmp = scan.nextLine();
		strList.add(tmp);
	}
	
	public static void removeFromList(Scanner scan) {
		displayList();
		System.out.println("Enter the number of the String you wish to remove:");
		int idx = scan.nextInt()-1;
		scan.nextLine();
		strList.remove(idx);
		strList.trimToSize();
	}
	
	public static void displayList() {
		System.out.println();
		System.out.println("Displaying list contents:");
		for(int i = 0; i < strList.size(); ++i) {
			System.out.println((i+1) + ". " + strList.get(i));
		}
	}

}
