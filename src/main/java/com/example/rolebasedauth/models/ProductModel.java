package com.example.rolebasedauth.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductModel {

    private Long productId;
    private String name;
    private Integer quantity;
    private double price;
}