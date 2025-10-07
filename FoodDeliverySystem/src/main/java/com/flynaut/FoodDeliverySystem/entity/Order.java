package com.flynaut.FoodDeliverySystem.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private int quantity;
    @Column
    private double total;
    @Column
    private String status;
    @Column
    private String date;
    @Column
    private String username;
    @Column
    private String customerName;
    @Column
    private String addressLine;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String pincode;
    @Column
    private String phoneNumber;
    @Column
    private String cakeImage;
}
