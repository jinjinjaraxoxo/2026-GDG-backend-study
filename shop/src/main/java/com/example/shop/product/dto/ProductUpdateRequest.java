package com.example.shop.product.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductUpdateRequest {

    private String name;
    private Integer price;
    private Integer stock;
}