package org.platform.car;

public class Runner {

	public static void main(String[] args) {
		Person bob = new Person(123456789, "Bob", "Doe");
		
		Car car1 = new Car(12345, "Honda");
		
		System.out.println(bob);
		System.out.println(car1);
		car1.printCar();
	}

}
