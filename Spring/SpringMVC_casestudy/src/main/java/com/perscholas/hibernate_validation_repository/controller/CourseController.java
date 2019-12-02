package com.perscholas.hibernate_validation_repository.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CourseController {
	@GetMapping("/coursecontroller")
	public String showSignIn(Model model) throws SQLException {
		
		return "Add";
	}
}
