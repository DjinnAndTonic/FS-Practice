package com.perscholas.cafe;

public class Coffee extends Product{
	private boolean sugar, milk;
	
	public Coffee() {
		super();
		sugar = false;
		milk = false;
	}
	
	public Coffee(String n, double p, String d, boolean s, boolean m) {
		super(n,p,d);
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

}
