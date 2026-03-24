package com.capge.stockmanagement.service;

import com.capge.stockmanagement.dto.OrderRequestDto;
import com.capge.stockmanagement.entity.Order;

public interface OrderService {
    Order createOrder(OrderRequestDto dto);
}