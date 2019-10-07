package com.perscholas.cafe;

public class Espresso extends Product {

	@Override
	public double calculateProductTotal() {
		// TODO Auto-generated method stub
		return getPrice() * getQuantity() + (getPrice() * getQuantity() * super.SALES_TAX);
	}

}
