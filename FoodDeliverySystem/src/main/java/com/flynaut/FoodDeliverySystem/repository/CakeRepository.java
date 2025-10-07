package com.flynaut.FoodDeliverySystem.repository;

import com.flynaut.FoodDeliverySystem.entity.CakeShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CakeRepository extends JpaRepository<CakeShop,Long> {
}
