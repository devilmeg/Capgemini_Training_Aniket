package com.capge.stockmanagement.dto;

import lombok.Data;
import java.util.Map;

@Data
public class OrderRequestDto {

    private Map<Integer, Integer> cart; // productId -> quantity
}