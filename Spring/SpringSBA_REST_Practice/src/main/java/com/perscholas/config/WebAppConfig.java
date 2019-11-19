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
import com.perscholas.models.Vehicle;

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
	 Map<Integer, Vehicle> vehicleMap(){
		 Map<Integer, Vehicle> vMap = new HashMap<>();
		 Vehicle v;
		 
		 //Entry 1
		 v = new Vehicle(1, "Toyota", "Camry", new String[] {"White", "Black", "Red"});
		 vMap.put(v.getVid(), v);
		 
		 v = new Vehicle(2, "Honda", "Accord", new String[] {"Red", "Blue", "White"});
		 vMap.put(v.getVid(), v);
		 
		 v = new Vehicle(3, "Ford", "Focus", new String[] {"Blue", "Red", "Yellow"});
		 vMap.put(v.getVid(), v);
		 
		 return vMap;
	 }
}
