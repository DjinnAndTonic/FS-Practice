package com.perscholas.sba07;

/*Write an application that includes a Car class with ID, 
 * price and description. Write a menu which allows the 
 * user to select a car to buy and print the invoice to the console.  
 * The invoice should include tax (6%), title fee ($150), and 
 * license fee (1.5%) along with purchase total.*/
public class Car {
	private int id;
	private double price;
	private String desc;
	private final double TAX = .06;
	private final double LISCENSE_FEE = .015;
	private final double TITLE_FEE = 150;
	
	public Car() {
		id = -1;
		price = -1;
		desc = "";
	}
	
	public Car(int id, double price, String desc) {
		super();
		this.id = id;
		this.price = price;
		this.desc = desc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getTAX() {
		return TAX;
	}

	public double getLISCENSE_FEE() {
		return LISCENSE_FEE;
	}

	public double getTITLE_FEE() {
		return TITLE_FEE;
	}
	
	public String getInvoice() {
		return "Car bought: \n" +
				"ID: " + getId() + "\n" +
				"Tax: $" + String.format("%.2f",getPrice()*getTAX()) + "\n" +
				"Title Fee: $" + getTITLE_FEE() + "\n" +
				"Liscense Fee: $" + String.format("%.2f", getPrice()*getLISCENSE_FEE()) + "\n" +
				"Total: $" + String.format("%.2f",(getPrice()+ getPrice()*getTAX() + getTITLE_FEE() + getPrice()*getLISCENSE_FEE()));
	}
	
	
	public String toString() {
		return "ID: " + getId() + ", \tPrice: $" + getPrice() + 
				"\n\tDescription: " + getDesc();
	}
}
