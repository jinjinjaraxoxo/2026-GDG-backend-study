package com.example.shop.product.repository;

import com.example.shop.product.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    void save(Product product);

    Optional<Product> findById(Long id);

    List<Product> findAll();

    void delete(Product product);
}
