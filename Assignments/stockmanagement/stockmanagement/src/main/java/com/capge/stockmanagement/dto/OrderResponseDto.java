package com.capge.stockmanagement.dto;

import lombok.Data;

@Data
public class OrderResponseDto {
    private int orderId;
    private double totalPrice;
    private double totalPriceWithGst;
}