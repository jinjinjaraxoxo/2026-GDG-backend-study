package com.example.shop.order.repository;

import com.example.shop.order.entity.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaOrderRepository implements OrderRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Order order) {
        if (order.getId() == null) {
            em.persist(order);
        } else {
            em.merge(order);
        }
    }

    @Override
    public Optional<Order> findById(Long id) {
        return Optional.ofNullable(em.find(Order.class, id));
    }

    @Override
    public List<Order> findAll() {
        return em.createQuery(
                "select o from Order o join fetch o.member join fetch o.product", Order.class)
                .getResultList();
    }

    @Override
    public void delete(Order order) {
        em.remove(order);
    }
}
