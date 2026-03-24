package com.capge.stockmanagement.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "order_info")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double totalPrice;
    private double totalPriceWithGst;
}