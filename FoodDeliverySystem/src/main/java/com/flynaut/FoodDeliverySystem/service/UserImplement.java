package com.flynaut.FoodDeliverySystem.service;

import com.flynaut.FoodDeliverySystem.entity.User;
import com.flynaut.FoodDeliverySystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserImplement implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public User register(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean login(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.isPresent() && user.get().getPassword().equals(password);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public long getLoggedInCount() {
        return userRepository.countByIsLoggedInTrue();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

