package com.example.shop.order.service;

import java.util.List;
import java.util.Map;

public interface OrderService {

    Map<String, Object> createOrder(Map<String, Object> request);

    List<Map<String, Object>> getOrders();

    Map<String, Object> getOrder(Long orderId);

    Map<String, Object> cancelOrder(Long orderId);
}
