package com.tourism.app.service;

import com.tourism.app.model.User;


import java.util.Optional;

public interface UserService {
    User register(User user);
    Optional<User> login(String email, String password);
//    Optional<User> findByEmail(String email);
    boolean emailExists(String email);
}