package com.flynaut.FoodDeliverySystem.service;

import com.flynaut.FoodDeliverySystem.entity.CakeShop;

import java.util.List;
import java.util.Optional;

public interface CakeService {
    CakeShop addCake(CakeShop cakeShop);
    List<CakeShop> getAllCake();
    Optional<CakeShop> getCakeById(long id);
    CakeShop updateCakeById(long id,CakeShop cakeShop);
    void deleteCakeById(long id);
}
