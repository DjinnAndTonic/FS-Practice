package com.perscholas.cafe;

public class Espresso extends Product {
//	extra shot = $2
//	macchiato = $1
	private boolean extraShot, macchiato;
	
	public Espresso() {
		super("Espresso", 2.00, "Something energetic.");
		extraShot = false;
		macchiato = false;
	}
	
	public Espresso(String n, double p, String d, boolean es, boolean m) {
		super(n,2.00,d);
		extraShot = es;
		macchiato = m;
	}

	@Override
	public double calculateProductTotal() {
		// TODO Auto-generated method stub
		return getPrice() * getQuantity() + (getPrice() * getQuantity() * super.SALES_TAX);
	}
	
	public boolean isExtraShot() {
		return extraShot;
	}

	public void setExtraShot(boolean extraShot) {
		this.extraShot = extraShot;
	}

	public boolean isMacchiato() {
		return macchiato;
	}

	public void setMacchiato(boolean macchiato) {
		this.macchiato = macchiato;
	}

	@Override
	public void addOptions(boolean b1, boolean b2) {
		// TODO Auto-generated method stub
		extraShot = b1;
		macchiato = b2;
	}

	@Override
	public void printOptions() {
		// TODO Auto-generated method stub
		System.out.println("Item: \tEspresso\t\tPrice: $" + this.getPrice() + "\tQty: " + 
				this.getQuantity() + "\tSubtotal: $" + this.calculateSubTotal());
		System.out.print("\tExtra Shot ($2): ");
		System.out.print((extraShot)? "Yes" : "No");
		System.out.print("\t");
		System.out.print("Macchiato ($1): ");
		System.out.print((macchiato)? "Yes" : "No");
		System.out.println();
		
	}

	@Override
	public double calculateSubTotal() {
		double itemPrice = this.getPrice();
		
		if(extraShot)
			itemPrice += 2;
		if(macchiato)
			itemPrice += 1;
		
		return itemPrice * this.getQuantity();
	}
	
	

}
