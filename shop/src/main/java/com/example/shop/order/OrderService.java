package com.example.shop.order;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    public Map<String, Object> createOrder(Map<String, Object> request) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "주문 생성이 완료되었습니다.");
        response.put("memberId", request.get("memberId"));
        response.put("productId", request.get("productId"));
        response.put("quantity", request.get("quantity"));
        response.put("orderStatus", "CREATED");
        return response;
    }

    public List<Map<String, Object>> getOrders() {
        return List.of(
                Map.of(
                        "orderId", 1L,
                        "memberId", 1L,
                        "productId", 1L,
                        "quantity", 2,
                        "orderStatus", "CREATED"
                ),
                Map.of(
                        "orderId", 2L,
                        "memberId", 2L,
                        "productId", 2L,
                        "quantity", 1,
                        "orderStatus", "CREATED"
                )
        );
    }

    public Map<String, Object> getOrder(Long orderId) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("orderId", orderId);
        response.put("memberId", 1L);
        response.put("productId", 1L);
        response.put("quantity", 3);
        response.put("orderStatus", "CREATED");
        return response;
    }

    public Map<String, Object> cancelOrder(Long orderId) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "주문 취소가 완료되었습니다.");
        response.put("orderId", orderId);
        response.put("orderStatus", "CANCELED");
        return response;
    }
}