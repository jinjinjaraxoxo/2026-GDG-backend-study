package com.example.shop.order.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderCreateRequest {

    private Long memberId;
    private Long productId;
    private int quantity;
}