package com.perscholas.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.perscholas.models.Student;

@Configuration
@ComponentScan("com.perscholas.controllers")
public class WebAppConfig implements WebMvcConfigurer{
	 @Bean
	 InternalResourceViewResolver viewResolver() {
		 return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
	 }
	 
	 
	 @Bean
	 ObjectMapper objectMapper() {
		 return new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
	 }
	 
	 @Bean
	 RestTemplate restTemplate() {
		 return new RestTemplate();
	 }
	 
	 // Emulates a database
	 @Bean
	 Map<Integer, Student> vehicleMap(){
		 Map<Integer, Student> vMap = new HashMap<>();
		 Student s;
		 
//		 Application Developer, Data Engineering, Quality Engineering and Assurance
		 
		 //Entry 1
		 s = new Student(1, "Luke", "red1@space.com", new String[] {"Application Developer", " Data Engineering"});
		 vMap.put(s.getStudentId(), s);
		 
		 //Entry 2
		 s = new Student(2, "Leia", "red2@space.com", new String[] {"Quality Engineering", "Quality Assurance"});
		 vMap.put(s.getStudentId(), s);
		 
		 //Entry 3
		 s = new Student(3, "Anakin", "red3@space.com", new String[] {"Application Developer", "Red"});
		 vMap.put(s.getStudentId(), s);
		 
		 return vMap;
	 }
}
