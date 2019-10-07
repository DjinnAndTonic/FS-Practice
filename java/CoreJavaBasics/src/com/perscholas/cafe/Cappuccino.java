package com.perscholas.cafe;

public class Cappuccino extends Product{

	@Override
	public double calculateProductTotal() {
		// TODO Auto-generated method stub
		return getPrice() * getQuantity() + (getPrice() * getQuantity() * super.SALES_TAX);
	}

}
