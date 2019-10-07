package com.perscholas.cafe;

public abstract class Product {
	private String name, desc;
	private double price;
	private int quantity;
	final protected double SALES_TAX = 0.0865;
	public Product() {
		super();
	}
	
	public Product(String n, double p, String d) {
		name = n;
		price = p;
		desc = d;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public abstract double calculateProductTotal();
//	{
//		return price * quantity + (price * quantity * SALES_TAX);
//	}
}
