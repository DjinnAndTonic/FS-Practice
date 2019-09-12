package org.platform.car;

public class Car {
	private int vin;
	private String make;
	
	public Car() {
		vin = 0;
		make = "";
	}
	
	public Car(int vin, String make) {
		this.vin = vin;
		this.make = make;
	}
	
	public void printCar() {
		System.out.println("Vin: " + vin);
		System.out.println("Make: " + make);
	}
	
	public String toString() {
		return "Vin: " + vin + "\n" +
				"Make: " + make + "\n";
	}
}
