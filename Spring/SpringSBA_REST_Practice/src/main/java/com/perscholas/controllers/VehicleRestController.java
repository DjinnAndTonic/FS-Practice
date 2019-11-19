package com.perscholas.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.perscholas.models.Vehicle;

@RestController
public class VehicleRestController {
	private Map<Integer, Vehicle> vMap;
	private ObjectMapper mapper;
	
	@Autowired
	public VehicleRestController(Map<Integer, Vehicle> v, ObjectMapper m) {
		vMap = v;
		mapper = m;
	}
	
	@GetMapping(value="/", produces="text/html")
	public String showWelcomeMessage() {
		return "<h1>Vehicle REST API Example</h1>";
	}
	
	@GetMapping("/car/{vid}")
	public String getVehicle(@PathVariable Integer vid) throws JsonProcessingException {
		if(vMap.get(vid) != null) {
			Vehicle v = vMap.get(vid);
			
			return mapper.writeValueAsString(v);
		}
		
		return "Vehicle ID not found.";
	}
	
	@GetMapping("/allcars")
	public String getAllVehicles() throws JsonProcessingException {
		return mapper.writeValueAsString(vMap);
	}
}
