package com.perscholas.selenium_exercise__css_xpath.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String showExercise01() {
		return "SeleniumExercisePageCssXpath";
	}
}