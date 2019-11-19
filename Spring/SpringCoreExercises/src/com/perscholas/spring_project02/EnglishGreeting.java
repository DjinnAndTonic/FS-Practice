package com.perscholas.spring_project02;

import com.perscholas.spring_project02.greetings_intf.Greetings;

public class EnglishGreeting implements Greetings{

	@Override
	public String sayHello() {
		return "Hello!";
	}

	@Override
	public String sayWelcome() {
		return "Welcome!";
	}

}
