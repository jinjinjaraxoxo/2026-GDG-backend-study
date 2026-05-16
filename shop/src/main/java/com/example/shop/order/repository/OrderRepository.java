package com.example.shop.order.repository;

import com.example.shop.order.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    void save(Order order);

    Optional<Order> findById(Long id);

    List<Order> findAll();

    void delete(Order order);
}
