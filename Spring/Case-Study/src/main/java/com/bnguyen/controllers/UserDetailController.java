package com.bnguyen.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bnguyen.models.User;
import com.bnguyen.models.UserDetail;
import com.bnguyen.respository.UserDetailRepository;
import com.bnguyen.respository.UserRepository;

@Controller
public class UserDetailController {
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserDetailRepository userDetailRepo;
	
	@GetMapping("/")
	public String showLandingPage(Model model) {
		model.addAttribute("loginUser", new User());
		return "login";
	}
	
	@GetMapping("/register")
	public String showRegisterPage(Model model) {
		model.addAttribute("registerUser", new User());
		model.addAttribute("userDetail", new UserDetail());
		return "register";
	}
	
	@PostMapping("/verifyRegister")
	public String verifyRegister(@Valid @ModelAttribute("registerUser") UserDetail ud,
			BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			model.addAttribute("userDetail", new UserDetail());
			System.out.println("Something's wrong! " + ud);
			return "register";
		}
		
//		userRepo.addUser(new User(ud.getEmail(), ud.getPassword()));
		userDetailRepo.addUserDetail(ud);
		
		System.out.println("Added " + ud);
		
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String showLoginPage(Model model) {
		model.addAttribute("loginUser", new User());
		return "login";
	}
	
	@PostMapping("/verifyLogin")
	public String verifyLogin(@Valid @ModelAttribute("loginUser") User u,
			BindingResult result, Model model) {
		
		User user = null;
		if(result.hasErrors()) {
			return "login";
		}
		
		user = userRepo.getUser(u.getUsername());
		
		System.out.println(user);
		System.out.println("Password: " + user.getPassword());
		System.out.println("Password: " + u.getPassword());
		
		if(user.getPassword().equals(u.getPassword())) {
			return "redirect:/home";
		}
		
		return "login";
	}
	
	@GetMapping("/home")
	public String showHomePage(Model model) {
		return "home";
	}
}
