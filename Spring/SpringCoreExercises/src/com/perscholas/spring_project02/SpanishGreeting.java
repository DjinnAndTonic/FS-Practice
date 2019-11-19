package com.perscholas.spring_project02;

import com.perscholas.spring_project02.greetings_intf.Greetings;

public class SpanishGreeting implements Greetings {

	@Override
	public String sayHello() {
		return "Hola";
	}

	@Override
	public String sayWelcome() {
		return "Bienvenidos a todos";
	}

}
