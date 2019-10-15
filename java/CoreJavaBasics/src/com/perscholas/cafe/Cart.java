package com.perscholas.cafe;

import java.util.ArrayList;

public class Cart {
	private static ArrayList<Product> shoppingCart = new ArrayList<Product>();
	
	public void addItem(Product p) {
		shoppingCart.add(p);
	}
	
	public void printCart() {
		for(Product p : shoppingCart)
			p.printOptions();
	}
	
	public double getPurchaseSubtotal() {
		double totSub = 0.0;
		for(Product p: shoppingCart)
			totSub += p.calculateSubTotal();
		return totSub;
			
	}
}
