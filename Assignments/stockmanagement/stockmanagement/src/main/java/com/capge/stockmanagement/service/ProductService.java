package com.capge.stockmanagement.service;

import com.capge.stockmanagement.entity.Product;
import java.util.List;

public interface ProductService {

    Product addProduct(Product product);
    Product updateProduct(int id, Product product);
    List<Product> searchByName(String name);
}