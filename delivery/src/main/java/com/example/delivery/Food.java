package com.example.delivery;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import javax.persistence.*;

@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private Double price;
    private String category;

    // Constructors, Getters and Setters
}
