//package com.tourism.app.service.impl;
//
//import com.tourism.app.model.User;
//import com.tourism.app.repository.UserRepository;
//import com.tourism.app.service.UserService;
//
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private UserRepository userRepo;
//    
//    
//
//    @Override
//    @Transactional
//    public User register(User user) {
//        // Ensure ID is null
//        user.setId(null);
//
//        // Check if email already exists
//        if (userRepo.findByEmail(user.getEmail()).isPresent()) {
//            throw new RuntimeException("User with email already exists");
//        }
//
//        // TODO: Add password encoding if needed
//        return userRepo.save(user);
//    }
//
//    @Override
//    public Optional<User> login(String email, String password) {
//        return userRepo.findByEmail(email)
//                .filter(u -> u.getPassword().equals(password));
//    }
//}
package com.tourism.app.service.impl;

import com.tourism.app.model.User;
import com.tourism.app.repository.UserRepository;
import com.tourism.app.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, 
                         PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(User user) {
    	
    	 // Ensure ID is null
      user.setId(null);
    	
        // Debug logging
        System.out.println("[DEBUG] Registering user: " + user.getEmail());
        System.out.println("[DEBUG] Raw password: " + user.getPassword());
        
        
        // Check if email already exists
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            logger.warn("Registration failed - email already exists: {}", user.getEmail());
            throw new IllegalArgumentException("Email already registered");
        }

        
        // Encode password before saving
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        
        System.out.println("[DEBUG] Encoded password: " + encodedPassword);
        
        User savedUser = userRepository.save(user);
        System.out.println("[DEBUG] User registered with ID: " + savedUser.getId());
        return savedUser;
    }

    public Optional<User> login(String email, String password) {
        // Debug logging
        System.out.println("[DEBUG] Login attempt for: " + email);
        
        Optional<User> userOpt = userRepository.findByEmail(email);
        
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            System.out.println("[DEBUG] Found user: " + user.getEmail());
            System.out.println("[DEBUG] Stored password hash: " + user.getPassword());
            System.out.println("[DEBUG] Input password: " + password);
            
            // Verify password
            boolean matches = passwordEncoder.matches(password, user.getPassword());
            System.out.println("[DEBUG] Password matches: " + matches);
            
            if (matches) {
                return Optional.of(user);
            }
        } else {
            System.out.println("[DEBUG] No user found with email: " + email);
        }
        
        return Optional.empty();
    }
    
    public boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}