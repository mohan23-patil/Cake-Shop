package com.flynaut.FoodDeliverySystem.service;

import com.flynaut.FoodDeliverySystem.entity.Admin;

public interface AdminService {
    Admin register(Admin admin);
    boolean login(String userName,String password);
}