package com.perscholas.classes;

import com.perscholas.dao.*;
import com.perscholas.classes.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Runner {
	private static List<Product> productList;
	private static ProductDAO pdao;
	
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		pdao = new ProductDAO();
		generateList();
		
		File file = new File("orders.txt");
		Scanner scan = new Scanner(file);
		
		double totalPrice = 0.0;
		
		scan.nextLine();
		
		while(scan.hasNext()) {
			String line = scan.nextLine();
			
			String[] order = line.split(" ");
			String name = order[0].trim();
			int quantity = Integer.parseInt(order[1]);
			double price = pdao.getSelectedProduct(name).getPrice();
			
			System.out.println("Order:\n   " + order[0] + " -- $" + 
					price + "*" + quantity + "\n   Total: $" + price*quantity + "\n");
			totalPrice += price*quantity;
		}
		
		System.out.println("Total of all orders: $" + totalPrice);
		scan.close();
	}
	
	public static void generateList() throws SQLException {
		productList = pdao.getAllProducts();
	}
	
//	public static void displayMenu() {		
//		System.out.println("\t\tMenu");
//		System.out.println("------------------------------------");
//		for(int i = 0; i < productList.size(); ++i) {
//			
//			System.out.println((i+1) + ": " + productList.get(i).getName()
//					+ " -- " + productList.get(i).getPrice());
//		}
//		System.out.println(productList.size()+1 + ": Checkout");
//	}
//	
//	public static void prompt() {
//		Scanner scan = new Scanner(System.in);
//		int choice = -1;
//		
//		System.out.print("\nSelection: ");
//		choice = scan.nextInt();
//		
//		while(choice != productList.size()+1) {
//			
//		}
//		
//		scan.close();
//	}
}
