package com.perscholas.cafe;

import java.util.Scanner;

public class CafeApp {
	private static Cart cart = new Cart();
	private final static double SALES_TAX = 0.0625;
	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {
		Scanner scan = new Scanner(System.in);
		int choice = -1;
		
		do {
			System.out.println("\nPlease select from the following menu:\r\n" + 
					"1: Coffee\r\n" + 
					"2: Cappuccino\r\n" + 
					"3: Espresso\r\n" + 
					"4: Check Out");
			System.out.print("Your Choice: ");
			choice = scan.nextInt();
			System.out.println();
			
			switch(choice){
				case 1:
					cart.addItem(buyCoffee());
					break;
				case 2:
					cart.addItem(buyCappuccino());
					break;
				case 3:
					cart.addItem(buyEspresso());
					break;
				case 4:
					checkout();
					break;
				default:
					System.out.println("Invalid Choice!");
					break;
			}
		}while (choice != 4);
		
		scan.close();
	}
	
	public static void checkout() {
		cart.printCart();
		System.out.printf("\nPurchase subtotal: $%.2f\n", cart.getPurchaseSubtotal());
		System.out.printf("Sales tax: $%.2f\n", (cart.getPurchaseSubtotal()*SALES_TAX));
		System.out.printf("Purchase Total: $%.2f", cart.getPurchaseSubtotal() + (cart.getPurchaseSubtotal()*SALES_TAX));
	}
	
	public static Coffee buyCoffee() {
		Scanner scan = new Scanner(System.in);
		String input = "";
		Coffee p = new Coffee();
		
		System.out.println("\nCoffee::");
		System.out.print("Do you want sugar? ");
		input = scan.nextLine().trim();
		p.setSugar(isTrue(input));
		System.out.print("Do you want milk? ");
		input = scan.nextLine().trim();
		p.setMilk(isTrue(input));
		System.out.print("How many? ");
		p.setQuantity(scan.nextInt());
		
		return p;
	}
	
	public static Espresso buyEspresso() {
		Scanner scan = new Scanner(System.in);
		String input = "";
		Espresso p = new Espresso();
		
		System.out.println("\nEspresso::");
		System.out.print("Do you want an extra shot? ");
		input = scan.nextLine().trim();
		p.setExtraShot(isTrue(input));
		System.out.print("Do you want to make it a macchiato? ");
		input = scan.nextLine().trim();
		p.setMacchiato(isTrue(input));
		System.out.print("How many? ");
		p.setQuantity(scan.nextInt());
		
		return p;
	}
	
	public static Cappuccino buyCappuccino() {
		Scanner scan = new Scanner(System.in);
		String input = "";
		Cappuccino p = new Cappuccino();
		
		System.out.println("\nCappuccino::");
		System.out.print("Do you want to add peppermint? ");
		input = scan.nextLine().trim();
		p.setPeppermint(isTrue(input));
		System.out.print("Do you want whipped cream? ");
		input = scan.nextLine().trim();
		p.setWhippedCream(isTrue(input));
		System.out.print("How many? ");
		p.setQuantity(scan.nextInt());
		
		return p;
	}
	
	public static boolean isTrue(String s) {
		return s.equalsIgnoreCase("YES");
	}
}
