package com.capge.stockmanagement.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "order_history_info")
@Data
public class OrderHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int orderId;
    private int productId;
}