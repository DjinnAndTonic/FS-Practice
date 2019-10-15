package com.perscholas.sba10;
/*Make two subclasses called Table and chair.
 * Add the field shape and length to the Table class and 
 * type and customColor (boolean) to the Chair class.*/
public class Table extends Furniture implements Cloneable {
	private String shape;
	private double length;

	public Table() {
		shape = "";
		length = 0;
	}
	
	public Table(String shape, double length) {
		this.shape = shape;
		this.length = length;
	}

	@Override
	protected double calculatePrice() {
		return getPrice() * getQuantity();
	}
	
	public String toString() {
		return "Shape: " + shape + "\tLength: " + length + 
				"\n\tQty: " + getQuantity() + "\tPrice: " + calculatePrice();
	}
	
	public Object clone() throws CloneNotSupportedException	{ 
		return super.clone(); 
	}

}
