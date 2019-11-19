package com.perscholas.spring_project02;

import com.perscholas.spring_project02.greetings_intf.Greetings;

public class Person {
	private Greetings greetings;

	public Person(Greetings greetings) {
		this.greetings = greetings;
	}
	
	public Greetings getGreetings() {
		return greetings;
	}
	
	public void setGreetings(Greetings g) {
		greetings = g;
	}
}
