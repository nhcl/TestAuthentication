package com.hcl.testAuthentication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@GetMapping("/")
	public String showGreeting(ModelMap map) {
		return "greeting";
	}

	@GetMapping("/login")
	public String showLogin(ModelMap map) {
		return "login";
	}

	@PostMapping("/submit")
	public String submitLogin() {
		System.out.print("In submit");
		return "success";
	}
}
