package com.perscholas.oop;

public class CarApp {
	public static void main(String[] args) {
		Car car1 = new Car();
		car1.setMake("Ford");
		car1.setModel("Mustang");
		car1.setYear(2017);
		car1.driveForward();
		car1.driveForward();
		car1.driveReverse();
		
		Car car2 = new Car("Toyota", "Camry", 2019);
		Car car3 = new Car("Honda", "Civic", 2017);
		
		Car[] carList = {car1, car2, car3};
		
		for(Car c : carList)		
			System.out.printf("Car Information:\nMake: %9s\nModel: %8s\nYear: %9d\nMiles: %8d\n\n", c.getMake(), c.getModel(), c.getYear(), c.getMiles());
	}
}
