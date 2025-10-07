package com.flynaut.FoodDeliverySystem.repository;

import com.flynaut.FoodDeliverySystem.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    Optional<Admin> findByUserName(String userName);
}