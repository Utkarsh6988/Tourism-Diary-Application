package com.tourism.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class LogoutController {
	
	@GetMapping("/logout")
	public String logoutPage(HttpSession session) {
	    session.invalidate(); // Clear the session
	    return "logout";      // Renders logout.html
	}
	@GetMapping("/logout-success")
	public String logoutPage() {
	    return "logout"; // logout.html from templates
	}


}
