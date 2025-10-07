package com.flynaut.FoodDeliverySystem.service;

import com.flynaut.FoodDeliverySystem.entity.Admin;
import com.flynaut.FoodDeliverySystem.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminImplment implements AdminService{

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin register(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public boolean login(String userName, String password) {
        Optional<Admin> admin = adminRepository.findByUserName(userName);
        return admin.isPresent() && admin.get().getPassword().equals(password);
    }
}

