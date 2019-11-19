package com.perscholas.spring_project01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringGreetingApp {
	public static void main(String[] args) {
		// created context
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("\\com\\perscholas\\spring_project01\\bean_def\\BeanDef.xml");
		
		SpringGreeting sg = context.getBean("springGreeting", SpringGreeting.class);
		
		System.out.println(sg.returnGreeting());
		
		context.close();
	}
}
