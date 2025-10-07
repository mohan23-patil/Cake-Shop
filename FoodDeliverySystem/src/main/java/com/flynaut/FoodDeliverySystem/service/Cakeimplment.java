package com.flynaut.FoodDeliverySystem.service;

import com.flynaut.FoodDeliverySystem.entity.CakeShop;
import com.flynaut.FoodDeliverySystem.repository.CakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Cakeimplment implements CakeService{

    @Autowired
    private CakeRepository cakeRepository;

    @Override
    public CakeShop addCake(CakeShop cakeShop) {
        return cakeRepository.save(cakeShop);
    }

    @Override
    public List<CakeShop> getAllCake() {
        return cakeRepository.findAll();
    }

    @Override
    public Optional<CakeShop> getCakeById(long id) {
        return cakeRepository.findById(id);
    }

    @Override
    public CakeShop updateCakeById(long id, CakeShop cakeShop) {
        CakeShop exitCake = cakeRepository.findById(id).orElse(null);
        if (exitCake != null){
            exitCake.setName(cakeShop.getName());
            exitCake.setDescription(cakeShop.getDescription());
            exitCake.setPrice(cakeShop.getPrice());
            exitCake.setImage(cakeShop.getImage());
            return cakeRepository.save(exitCake);
        }
        throw new RuntimeException("Cake not Found Here");
    }

    @Override
    public void deleteCakeById(long id) {
        cakeRepository.deleteById(id);
    }
}
