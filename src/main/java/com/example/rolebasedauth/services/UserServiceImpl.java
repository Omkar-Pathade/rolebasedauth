package com.example.rolebasedauth.services;

import com.example.rolebasedauth.entities.Product;
import com.example.rolebasedauth.entities.User;
import com.example.rolebasedauth.models.ProductModel;
import com.example.rolebasedauth.repositories.ProductRepository;
import com.example.rolebasedauth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public String addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User Added Successfully";
    }

    @Override
    public List<ProductModel> getAllProducts() {
        List<Product> prod= productRepository.findAll();
        List<ProductModel> pm = new ArrayList<>();
        for (Product p :prod) {
            pm.add(new ProductModel(p));
        }
        return pm;
    }

    @Override
    public ProductModel getProductById(Long id) {
        Optional<Product> prod = productRepository.findById(id);
        ProductModel pm = null;
        if(prod.isPresent()){
            pm = new ProductModel(prod.get());
        }
        return pm;
    }

    @Override
    public String addProduct(ProductModel productModel) {
        Product product = new Product();
        User user = userRepository.findById(productModel.getUserid()).get();
        product.setUser(user);
        product.setName(productModel.getName());
        product.setPrice(productModel.getPrice());
        product.setQuantity(productModel.getQuantity());
        productRepository.save(product);
        return "Product Added";
    }


}
