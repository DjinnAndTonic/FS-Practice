package com.perscholas.spring_project02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingsApp {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("\\com\\perscholas\\bean_def\\BeanDef2.xml");
		
		Person p = context.getBean("person", Person.class);
		
		System.out.println(p.getGreetings().sayHello());
		
		context.close();
	}
	
}
