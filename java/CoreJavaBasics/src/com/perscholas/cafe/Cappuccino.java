package com.perscholas.cafe;

public class Cappuccino extends Product{
	private boolean peppermint, whippedCream;
	
	public Cappuccino() {
		super("Cappuccino", 4.25, "Something sweeter.");
		peppermint = false;
		whippedCream = false;
	}
	
	public Cappuccino(String n, double p, String d, boolean es, boolean m) {
		super(n,4.25,d);
		peppermint = es;
		whippedCream = m;
	}
	
	@Override
	public double calculateProductTotal() {
		return getPrice() * getQuantity() + (getPrice() * getQuantity() * super.SALES_TAX);
	}

	@Override
	public void printOptions() {
		System.out.println("Item: \tCappuccino\tPrice: $" + this.getPrice() + "\tQty: " + 
				this.getQuantity() + "\tSubtotal: $" + this.calculateSubTotal());
		System.out.print("\tPeppermint ($2): ");
		System.out.print((peppermint)? "Yes" : "No");
		System.out.print("\t");
		System.out.print("Whipped Cream ($1): ");
		System.out.print((whippedCream)? "Yes" : "No");
		System.out.println();
	}

	public boolean isPeppermint() {
		return peppermint;
	}

	public void setPeppermint(boolean peppermint) {
		this.peppermint = peppermint;
	}

	public boolean isWhippedCream() {
		return whippedCream;
	}

	public void setWhippedCream(boolean whippedCream) {
		this.whippedCream = whippedCream;
	}

	@Override
	public double calculateSubTotal() {
		double itemPrice = this.getPrice();
		
		if(peppermint)
			itemPrice += 2;
		if(whippedCream)
			itemPrice += 1;
		
		return itemPrice * this.getQuantity();
	}

	@Override
	public void addOptions(boolean b1, boolean b2) {
		peppermint = b1;
		whippedCream = b2;
		
	}

}
