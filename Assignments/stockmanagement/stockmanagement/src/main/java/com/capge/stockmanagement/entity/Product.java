package com.capge.stockmanagement.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products_info")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String category;
    private String company;
    private int quantity;
    private double price;
}