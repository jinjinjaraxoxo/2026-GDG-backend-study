package com.example.shop.order.entity;

import com.example.shop.member.entity.Member;
import com.example.shop.product.entity.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "status", length = 20)
    private String status;

    public Order(Member member, Product product, int quantity) {
        this.member = member;
        this.product = product;
        this.quantity = quantity;
        this.status = "ORDERED";
    }

    public void cancel() {
        this.status = "CANCELLED";
    }
}
