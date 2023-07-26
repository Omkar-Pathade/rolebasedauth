package com.example.rolebasedauth.services;

import com.example.rolebasedauth.entities.User;
import com.example.rolebasedauth.models.ProductModel;

import java.util.List;

public interface UserService {
    String addUser(User user);

    List<ProductModel> getAllProducts();

    ProductModel getProductById(Long id);

    String addProduct(ProductModel productModel);

    List<ProductModel> getAllProductsByUserId(Long id);
}
