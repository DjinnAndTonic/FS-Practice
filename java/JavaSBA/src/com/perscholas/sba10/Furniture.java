package com.perscholas.sba10;
/*Create an abstract class named Furniture with the fields productId, 
 * name, price, color, and quantity. Include the abstract method calculatePrice().*/
public abstract class Furniture {
	private int productId, quantity;
	private String name, color;
	private double price;
	protected final double SALES_TAX = 0.0625;
	
	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getSALES_TAX() {
		return SALES_TAX;
	}


	protected abstract double calculatePrice();
}
