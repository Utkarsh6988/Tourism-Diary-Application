package com.tourism.app.controller;

import com.tourism.app.model.User;


import com.tourism.app.service.UserService;

import jakarta.servlet.http.HttpSession;

//import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            User savedUser = userService.register(user);
            return ResponseEntity.ok(savedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginApi(@RequestBody User user, HttpSession session) {
        return userService.login(user.getEmail(), user.getPassword())
                .map(u -> {
                    session.setAttribute("user", u);
                    return ResponseEntity.ok("Login Successful");
                })
                .orElse(ResponseEntity.status(401).body("Invalid Credentials"));
    }
    
  
}
