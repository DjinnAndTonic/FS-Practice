package com.perscholas.file;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class SoftwareDeveloperClub {
	private static ArrayList<ClubMember> membersList = new ArrayList<ClubMember>();
	
	public SoftwareDeveloperClub() throws Exception{
		File file = new File("members.txt");
		Scanner scan = new Scanner(file);
		
		String format = scan.nextLine();
		System.out.println("Text File is organized as so:\n" + format);
		System.out.println();
		
		while(scan.hasNext()) {
			String[] member = scan.nextLine().split("[*]+");
			membersList.add(new ClubMember(member[0], member[1], member[2], member[3]));
		}
		scan.close();
	}
	
	public void menu() throws Exception {
		Scanner scan = new Scanner(System.in);
		int choice = -1;
		do {
			System.out.println("\nSelect from the following menu:\r\n" + 
					"1: Display Members\r\n" + 
					"2: Remove Member\r\n" + 
					"3: Add Member\r\n" + 
					"4: Quit");
			System.out.print("Selection: ");
			choice = scan.nextInt();
			System.out.println();

			if(choice == 1) {
				printMembers();
			}
			else if(choice == 2) {
				removeMember();
				continue;
			}
			else if(choice == 3) { 
				addMember();
				continue;
			}
			else if(choice == 4) 
				System.out.println("Goodbye!");
			else {
				System.out.println("Invalid choice.");
				continue;
			}
		} while(choice != 4);
		System.out.println();
		scan.close();
	}
	
	public static void removeMember() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Remove a member...");
		System.out.print("Enter name of member to remove: ");
		String n = scan.nextLine().trim();
		for(int i = 0; i < membersList.size(); ++i) {
			if(membersList.get(i).getName().equalsIgnoreCase(n)) {
				membersList.remove(i);
			}
		}
	}
	
	public static void addMember() {
		ClubMember c = new ClubMember();
		Scanner scan = new Scanner(System.in);
		System.out.println("Add a new club member..");
		System.out.print("\nName: ");
		c.setName(scan.nextLine().trim());
		System.out.print("City: ");
		c.setCity(scan.nextLine().trim());
		System.out.print("State: ");
		c.setState(scan.nextLine().trim());
		System.out.print("Favorite Language: ");
		c.setLang(scan.nextLine().trim());
		
		membersList.add(c);
	}
	
	public static void printMembers() throws Exception{
		for(ClubMember mem : membersList)
			System.out.println(mem + "\n");			
	}
}
