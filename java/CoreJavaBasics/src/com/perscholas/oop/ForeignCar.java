package com.perscholas.oop;

public class ForeignCar  extends Car{
	public ForeignCar() {
		super();
	}
	
	public ForeignCar(int year) {
		super(year);
	}
	
	public ForeignCar(String make, String model, int year) {
		super(make, model, year);
	}
}
