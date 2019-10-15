package com.perscholas.sba10;

import java.util.ArrayList;
import java.util.Scanner;

public class JavaSBAProject_10 {
	private static ArrayList<Furniture> cart =new ArrayList<Furniture>();
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int choice  = -1;
		
		Table t1 = new Table("Square", 60);
		t1.setPrice(200);
		Table t2 = new Table("Rectangle", 84);
		t2.setPrice(450);
		Chair c1 = new Chair("Recliner", false);
		c1.setPrice(150);
		Chair c2 = new Chair("Office", true);
		c2.setPrice(150);
		
		System.out.println("Welcome to the Extremely Limited Furniture Store!");
		
		while(choice != 5) {
			int q = 0;
			try {
				System.out.println("\nOur Items\n"
						+ "1. Table - Square (60 in)\n"
						+ "2. Table - Rectable (84 in)\n"
						+ "3. Chair - Recliner\n"
						+ "4. Chair - Office (Custom color)\n"
						+ "5. Checkout");
				System.out.print("Selection: ");
				choice = scan.nextInt();
				
				switch(choice) {
				case 1:
					System.out.println("How many: ");
					q = scan.nextInt();
					t1.setQuantity(q);
					cart.add((Furniture) t1.clone());
					break;
				case 2:
					System.out.println("How many: ");
					q = scan.nextInt();
					t2.setQuantity(q);
					cart.add((Furniture) t2.clone());
					break;
				case 3:
					System.out.println("How many: ");
					q = scan.nextInt();
					c1.setQuantity(q);
					cart.add((Furniture) c1.clone());
					break;
				case 4:
					System.out.println("How many: ");
					q = scan.nextInt();
					c2.setQuantity(q);
					cart.add((Furniture)c2.clone());
					break;
				case 5:
					System.out.println("Checking out...\n");
					checkout();
					break;
				default:
					System.out.println("Invalid Choice.");
					break;
				}
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("Invalid input. Program terminating.");
				break;
			}
		}		
		scan.close();
	}
	
	private static void checkout() {
		double total = 0;
		for(Furniture f : cart) {
			System.out.println(f);
		}
		for(Furniture f : cart) {
			total += f.calculatePrice();
		}
		
		System.out.printf("Subtotal: $%.2f\n", total);
		System.out.printf("Tax: $%.2f\n", total * 0.0625);
		System.out.printf("Purchase Total: $%.2f\n", total + (total * 0.0625));
	}
}
