package com.example.shop.order.service;

import com.example.shop.member.entity.Member;
import com.example.shop.member.repository.MemberRepository;
import com.example.shop.order.entity.Order;
import com.example.shop.order.repository.OrderRepository;
import com.example.shop.product.entity.Product;
import com.example.shop.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;

    @Override
    public Map<String, Object> createOrder(Map<String, Object> request) {
        Long memberId = Long.valueOf(request.get("memberId").toString());
        Long productId = Long.valueOf(request.get("productId").toString());
        int quantity = Integer.parseInt(request.get("quantity").toString());

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다. id=" + memberId));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다. id=" + productId));

        Order order = new Order(member, product, quantity);
        orderRepository.save(order);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "주문 생성이 완료되었습니다.");
        response.put("orderId", order.getId());
        response.put("memberId", memberId);
        response.put("productId", productId);
        response.put("quantity", quantity);
        response.put("status", order.getStatus());
        return response;
    }

    @Override
    public List<Map<String, Object>> getOrders() {
        return orderRepository.findAll().stream()
                .map(this::toMap)
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, Object> getOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("주문을 찾을 수 없습니다. id=" + orderId));
        return toMap(order);
    }

    @Override
    public Map<String, Object> cancelOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("주문을 찾을 수 없습니다. id=" + orderId));
        order.cancel();

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "주문 취소가 완료되었습니다.");
        response.put("orderId", orderId);
        response.put("status", order.getStatus());
        return response;
    }

    private Map<String, Object> toMap(Order order) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("orderId", order.getId());
        map.put("memberId", order.getMember().getId());
        map.put("productId", order.getProduct().getId());
        map.put("quantity", order.getQuantity());
        map.put("status", order.getStatus());
        return map;
    }
}
