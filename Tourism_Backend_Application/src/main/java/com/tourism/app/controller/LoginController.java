//package com.tourism.app.controller;
//
//import com.tourism.app.model.User;
//
//import com.tourism.app.service.UserService;
//import jakarta.servlet.http.HttpSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import java.util.Optional;
//
//@Controller
//public class LoginController {
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/login")
//    public String loginForm(
//            @RequestParam("email") String email,
//            @RequestParam("password") String password,
//            HttpSession session,
//            Model model,
//            @RequestParam(name = "redirect", required = false) String redirectUrl) {
//        
//        Optional<User> userOpt = userService.login(email, password);
//        System.out.println(userOpt);
//        
//        if (userOpt.isPresent()) {
//            User user = userOpt.get();
//            session.setAttribute("user", user);
//            session.setAttribute("username", user.getName());
//            
//            // Redirect to original requested URL or home
//            return "redirect:" + (redirectUrl != null ? redirectUrl : "/home");
//        } else {
//            model.addAttribute("error", "Invalid email or password");
//            return "login";
//        }
//    }
//
//    @GetMapping("/login")
//    public String loginPage(@RequestParam(name = "redirect", required = false) String redirectUrl, Model model) {
//        model.addAttribute("redirect", redirectUrl);
//        return "login";
//    }
//}
package com.tourism.app.controller;

import com.tourism.app.model.User;

import com.tourism.app.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String processLogin(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam(name = "redirect", required = false) String redirectUrl,
            HttpSession session,
            RedirectAttributes redirectAttributes) {
        
        logger.debug("Login attempt for email: {}", email);
        
        try {
            Optional<User> userOpt = userService.login(email, password);
            
            if (userOpt.isPresent()) {
                User user = userOpt.get();
                session.setAttribute("user", user);
                session.setAttribute("username", user.getName());
                logger.info("User {} logged in successfully", user.getEmail());
                
                // Prevent open redirect vulnerabilities
                String targetUrl = redirectUrl != null && !redirectUrl.isEmpty() && 
                                  (redirectUrl.startsWith("/") || redirectUrl.startsWith("http://localhost")) 
                                  ? redirectUrl : "/home";
                
                return "redirect:" + targetUrl;
            } else {
                logger.warn("Failed login attempt for email: {}", email);
                redirectAttributes.addFlashAttribute("error", "Invalid email or password");
                return "redirect:/login";
            }
        } catch (Exception e) {
            logger.error("Login error for email {}: {}", email, e.getMessage());
            redirectAttributes.addFlashAttribute("error", "An error occurred during login");
            return "redirect:/login";
        }
    }

    @GetMapping("/login")
    public String showLoginPage(
            @RequestParam(name = "redirect", required = false) String redirectUrl,
            @RequestParam(name = "error", required = false) String error,
            @RequestParam(name = "logout", required = false) String logout,
            Model model) {
        
        if (error != null) {
            model.addAttribute("error", "Invalid email or password");
        }
        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully");
        }
        
        model.addAttribute("redirect", redirectUrl);
        return "login";
    }
    // Registration GET
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // Registration POST
    @PostMapping("/register")
    public String processRegistration(
            @RequestParam("fullName") String fullName,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("confirmPassword") String confirmPassword,
            RedirectAttributes redirectAttributes,
            Model model) {
        
        logger.debug("Registration attempt for email: {}", email);
        
        // Basic validation
        if (fullName == null || fullName.trim().isEmpty()) {
            model.addAttribute("error", "Full name is required");
            return "register";
        }
        
        if (email == null || email.trim().isEmpty() || !email.contains("@")) {
            model.addAttribute("error", "Valid email is required");
            return "register";
        }
        
        if (password == null || password.length() < 6) {
            model.addAttribute("error", "Password must be at least 6 characters");
            return "register";
        }
        
        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match");
            return "register";
        }
        
        // Check if email exists
        if (userService.emailExists(email)) {
            model.addAttribute("error", "Email already in use");
            return "register";
        }
        
        try {
            User newUser = new User();
            newUser.setName(fullName);
            newUser.setEmail(email);
            newUser.setPassword(password); // Make sure to hash the password in service layer
            
            User registeredUser = userService.register(newUser);
            logger.info("New user registered: {}", registeredUser.getEmail());
            
            redirectAttributes.addFlashAttribute("success", "Registration successful! Please login.");
            return "redirect:/login";
        } catch (Exception e) {
            logger.error("Registration error for email {}: {}", email, e.getMessage());
            model.addAttribute("error", "Registration failed. Please try again.");
            return "register";
        }
    }
}
