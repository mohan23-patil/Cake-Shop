package com.flynaut.FoodDeliverySystem.service;

import com.flynaut.FoodDeliverySystem.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User register(User user);
    boolean login(String username,String password);
    Optional<User> findByUsername(String username);
    long getLoggedInCount();
    List<User> getAllUsers();
}

