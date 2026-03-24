package com.capge.stockmanagement.controller;

import com.capge.stockmanagement.dto.OrderRequestDto;
import com.capge.stockmanagement.entity.Order;
import com.capge.stockmanagement.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public Order createOrder(@RequestBody OrderRequestDto dto) {
        return service.createOrder(dto);
    }
}