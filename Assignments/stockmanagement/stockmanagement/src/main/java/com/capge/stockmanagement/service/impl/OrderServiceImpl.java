package com.capge.stockmanagement.service.impl;

import com.capge.stockmanagement.dto.OrderRequestDto;
import com.capge.stockmanagement.entity.Order;
import com.capge.stockmanagement.entity.Product;
import com.capge.stockmanagement.repository.OrderRepository;
import com.capge.stockmanagement.repository.ProductRepository;
import com.capge.stockmanagement.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderServiceImpl(ProductRepository productRepository,
                            OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(OrderRequestDto dto) {

        double total = 0;

        for (var entry : dto.getCart().entrySet()) {

            Product product = productRepository.findById(entry.getKey())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            int qty = entry.getValue();

            if (product.getQuantity() < qty) {
                throw new RuntimeException("Insufficient stock");
            }

            total += product.getPrice() * qty;

            product.setQuantity(product.getQuantity() - qty);
            productRepository.save(product);
        }

        Order order = new Order();
        order.setTotalPrice(total);
        order.setTotalPriceWithGst(total * 1.18);

        return orderRepository.save(order);
    }
}