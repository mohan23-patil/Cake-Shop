package com.flynaut.FoodDeliverySystem.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users") // 👈 final table ka naam users rakho (plural common hai)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String mobile;

    @Column
    private String address;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "is_logged_in", nullable = false)
    private boolean isLoggedIn = false;
}
