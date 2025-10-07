package com.flynaut.FoodDeliverySystem.controller;

import com.flynaut.FoodDeliverySystem.entity.User;
import com.flynaut.FoodDeliverySystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user/auth")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        service.register(user);
        return ResponseEntity.ok(Map.of("success", true, "message", "User Registered Successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        boolean success = service.login(user.getUsername(), user.getPassword());
        if (success) {
            Optional<User> userDetails = service.findByUsername(user.getUsername());
            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "user", userDetails.orElse(null),
                    "message", "User Login Successful"
            ));
        } else {
            return ResponseEntity.status(401).body(Map.of(
                    "success", false,
                    "message", "Invalid Credentials"
            ));
        }
    }

    @GetMapping("/details/{username}")
    public ResponseEntity<?> getUserDetails(@PathVariable String username) {
        Optional<User> user = service.findByUsername(username);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(service.getAllUsers());
    }

}
