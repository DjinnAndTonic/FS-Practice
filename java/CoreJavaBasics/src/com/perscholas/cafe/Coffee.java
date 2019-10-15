package com.perscholas.cafe;

public class Coffee extends Product{
	private boolean sugar, milk;
	
	public Coffee() {
		super("Coffee", 3.75, "Something bitter.");
		sugar = false;
		milk = false;
	}
	
	public Coffee(String n, double p, String d, boolean s, boolean m) {
		super(n,3.75,d);
		sugar = s;
		milk = m;
	}

	public boolean isSugar() {
		return sugar;
	}

	public void setSugar(boolean sugar) {
		this.sugar = sugar;
	}

	public boolean isMilk() {
		return milk;
	}

	public void setMilk(boolean milk) {
		this.milk = milk;
	}

	@Override
	public double calculateProductTotal() {
		// TODO Auto-generated method stub
		return getPrice() * getQuantity() + (getPrice() * getQuantity() * super.SALES_TAX);
	}

	@Override
	public void addOptions(boolean b1, boolean b2) {
		// TODO Auto-generated method stub
		sugar = b1;
		milk = b2;
	}

	@Override
	public void printOptions() {
		System.out.println("Item: \tCoffee\t\tPrice: $" + this.getPrice() + "\tQty: " + 
				this.getQuantity() + "\tSubtotal: $" + this.calculateSubTotal());
		System.out.print("\tSugar: ");
		System.out.print((sugar)? "Yes" : "No");
		System.out.print("\t");
		System.out.print("Milk: ");
		System.out.print((milk)? "Yes" : "No");
		System.out.println();
		
	}

	@Override
	public double calculateSubTotal() {
		double itemPrice = this.getPrice();
		
		return itemPrice * this.getQuantity();
	}
}
