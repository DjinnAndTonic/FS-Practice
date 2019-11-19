package com.perscholas.helloperscholas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.perscholas.helloperscholas.beans.User;

@Controller
public class HomeController {
	
//	@GetMapping("/")
//	public String showHelloPage(Model model) {
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM d, yyyy h:mm a");
//		LocalDateTime now = LocalDateTime.now();
//		
//		String formattedLDT = now.format(dtf);
//		model.addAttribute("dateTime", formattedLDT);
//		return "Hello";
//	}
	
	@GetMapping("/")
	public String showRegisterPage(Model model) {
		return "Register";
	}
	
	@PostMapping("/login")
	public String showLoginPage(@Valid @RequestParam String username, @RequestParam String password, 
	User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "Register";
		}
		
		model.addAttribute("username", username);
		model.addAttribute("password", password);		
		
		System.out.println(username);
		System.out.println(password);
		return "Login";
	}
	
	
}
