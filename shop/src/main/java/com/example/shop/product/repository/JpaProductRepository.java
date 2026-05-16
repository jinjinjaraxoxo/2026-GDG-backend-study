package com.example.shop.product.repository;

import com.example.shop.product.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaProductRepository implements ProductRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Product product) {
        if (product.getId() == null) {
            em.persist(product);
        } else {
            em.merge(product);
        }
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(em.find(Product.class, id));
    }

    @Override
    public List<Product> findAll() {
        return em.createQuery("select p from Product p", Product.class)
                .getResultList();
    }

    @Override
    public void delete(Product product) {
        em.remove(product);
    }
}
