package com.perscholas.sba10;

/*Make two subclasses called Table and chair.
 * Add the field shape and length to the Table class and 
 * type and customColor (boolean) to the Chair class.*/
public class Chair extends Furniture implements Cloneable {
	private String type;
	boolean customColor;
	
	public Chair() {
		type = "";
		customColor = false;
	}
	
	public Chair(String type, boolean isCustom) {
		this.type = type;
		customColor = isCustom;
	}

	@Override
	protected double calculatePrice() {
		if(customColor)
			return (getPrice() + 50) * getQuantity();
		return getPrice()* getQuantity();
	}
	
	public String toString() {
		return "Type: " + type + "\tCustom color: " + customColor +
				"\n\tQty: " + getQuantity() + "\tPrice: " + calculatePrice();
	}
	
	public Object clone() throws CloneNotSupportedException	{ 
		return super.clone(); 
	}

}
