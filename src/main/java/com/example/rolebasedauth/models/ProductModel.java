package com.example.rolebasedauth.models;

import com.example.rolebasedauth.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {

    private Long productId;
    private String name;
    private Integer quantity;
    private double price;

    public ProductModel(Product product){
        this.productId = product.getId();
        this.name = product.getName();
        this.quantity = product.getQuantity();
        this.price = product.getPrice();
    }
}