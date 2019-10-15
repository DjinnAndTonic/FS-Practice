package com.perscholas.sba07;

import java.util.ArrayList;
import java.util.Scanner;

/*Write an application that includes a Car class with ID, 
 * price and description. Write a menu which allows the 
 * user to select a car to buy and print the invoice to the console.  
 * The invoice should include tax (6%), title fee ($150), and 
 * license fee (1.5%) along with purchase total.*/
public class JavaSBAProject_07 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Car> carList = new ArrayList<Car>();
		
		carList.add(new Car(11, 11111, "Fake car 1"));
		carList.add(new Car(22, 22222, "Fake car 2"));
		carList.add(new Car(33, 33333, "Fake car 3"));
		carList.add(new Car(44, 44444, "Fake car 4"));
		
		int choice = -1;
		for(int i = 0; i < carList.size(); ++i) {
			System.out.println((i+1) + ") " + carList.get(i));
		}
		System.out.print("Enter the number of the car you would like to buy: ");
		choice = scan.nextInt();
		
		if(choice < 1 || choice > 4)
			System.out.println("Invalid choice. Program terminating.");
		else {
			System.out.println(carList.get(choice-1).getInvoice());
		}
		
		scan.close();
	}
}
