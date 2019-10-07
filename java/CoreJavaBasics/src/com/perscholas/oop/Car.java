package com.perscholas.oop;

public class Car {
	private String make, model;
	private int year, miles;
	
	public Car() {
		make = "";
		model = "";
		year = -1;
		miles = 0;
	}
	
	public Car(int year) {
		this();
		this.year = year;
	}
	
	public Car(String make, String model, int year) {
		this.make = make;
		this.model = model;
		this.year = year;
		miles = 0;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMiles() {
		return miles;
	}

	public void setMiles(int miles) {
		this.miles = miles;
	}
	
	public void driveForward() {
		miles += 10;
	}
	public void driveReverse() {
		miles -= 10;
	}
	
	public final void finalKeyWordDemo() {
		System.out.println("Final Method Demo");
	}

}
