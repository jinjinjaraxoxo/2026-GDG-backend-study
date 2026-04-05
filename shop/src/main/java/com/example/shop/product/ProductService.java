package com.example.shop.product;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    public Map<String, Object> createProduct(Map<String, Object> request) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "상품 등록이 완료되었습니다.");
        response.put("productName", request.get("productName"));
        response.put("price", request.get("price"));
        response.put("stock", request.get("stock"));
        return response;
    }

    public List<Map<String, Object>> getProducts() {
        return List.of(
                Map.of(
                        "productId", 1L,
                        "productName", "키보드",
                        "price", 50000,
                        "stock", 10
                ),
                Map.of(
                        "productId", 2L,
                        "productName", "마우스",
                        "price", 30000,
                        "stock", 20
                )
        );
    }

    public Map<String, Object> getProduct(Long productId) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("productId", productId);
        response.put("productName", "샘플 상품");
        response.put("price", 10000);
        response.put("stock", 99);
        return response;
    }

    public Map<String, Object> updateProduct(Long productId, Map<String, Object> request) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "상품 수정이 완료되었습니다.");
        response.put("productId", productId);
        response.put("productName", request.get("productName"));
        response.put("price", request.get("price"));
        response.put("stock", request.get("stock"));
        return response;
    }

    public void deleteProduct(Long productId) {
    }
}