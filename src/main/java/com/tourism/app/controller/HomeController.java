package com.tourism.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tourism.app.model.User;

import jakarta.servlet.http.HttpSession;

//@Controller
//public class HomeController {
//
//    @GetMapping("/home")
//    public String homePage(Model model) {
//        model.addAttribute("username", "Utkarsh");
//        return "home"; // Refers to home.html in templates
//    }
//}
@Controller
public class HomeController {

    @GetMapping("/home")
    public String homePage(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            model.addAttribute("username", user.getName());
        } else {
            // Handle case where user is not logged in
        	return "redirect:/login?redirect=/home";
        }
        return "home";
    }
}