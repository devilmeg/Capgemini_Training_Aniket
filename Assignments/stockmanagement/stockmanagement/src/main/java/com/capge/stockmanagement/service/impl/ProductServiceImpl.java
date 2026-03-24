package com.capge.stockmanagement.service.impl;

import com.capge.stockmanagement.entity.Product;
import com.capge.stockmanagement.repository.ProductRepository;
import com.capge.stockmanagement.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product addProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Product updateProduct(int id, Product updated) {
        Product p = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        p.setName(updated.getName());
        p.setCategory(updated.getCategory());
        p.setCompany(updated.getCompany());
        p.setQuantity(updated.getQuantity());
        p.setPrice(updated.getPrice());

        return repository.save(p);
    }

    @Override
    public List<Product> searchByName(String name) {
        return repository.findByNameContaining(name);
    }
}