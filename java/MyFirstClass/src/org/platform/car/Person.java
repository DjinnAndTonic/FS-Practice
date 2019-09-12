package org.platform.car;

public class Person {
	private int ssNum;
	private String firstName, lastName;
	
	public Person() {
		ssNum = 0;
		firstName = "";
		lastName = "";
	}
	
	public Person(int ssNum, String firstName, String lastName) {
		this.ssNum = ssNum;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String toString() {
		return "S.S. Number: " + Integer.toString(ssNum) + "\n" +
				"Name: " + lastName +", " + firstName + "\n";
	}
}
