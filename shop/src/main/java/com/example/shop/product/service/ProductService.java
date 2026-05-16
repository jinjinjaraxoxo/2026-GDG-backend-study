package com.example.shop.product.service;

import com.example.shop.product.dto.ProductCreateRequest;
import com.example.shop.product.dto.ProductUpdateRequest;
import com.example.shop.product.entity.Product;

import java.util.List;

public interface ProductService {

    void createProduct(ProductCreateRequest request);

    List<Product> getProducts();

    Product getProduct(Long productId);

    void updateProduct(Long productId, ProductUpdateRequest request);

    void deleteProduct(Long productId);
}
