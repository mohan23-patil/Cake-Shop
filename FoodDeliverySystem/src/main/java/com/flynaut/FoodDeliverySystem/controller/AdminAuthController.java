package com.flynaut.FoodDeliverySystem.controller;

import com.flynaut.FoodDeliverySystem.entity.Admin;
import com.flynaut.FoodDeliverySystem.service.AdminService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin/auth")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AdminAuthController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Admin admin) {
        adminService.register(admin);
        return ResponseEntity.ok("Register");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Admin admin) {
        boolean success = adminService.login(admin.getUserName(), admin.getPassword());
        if (success) {
            return ResponseEntity.ok("Login Successful");
        } else {
            return ResponseEntity.status(401).body("Invalid Credentials");
        }
    }

}
