package com.example.rolebasedauth.controllers;

import com.example.rolebasedauth.entities.User;
import com.example.rolebasedauth.models.AuthRequest;
import com.example.rolebasedauth.models.ProductModel;
import com.example.rolebasedauth.services.JwtService;
import com.example.rolebasedauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/new")
    public String addNewUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/all")
    @Secured("ROLE_USER")
    public List<ProductModel> getAllProducts(){
        return userService.getAllProducts();
    }

    @GetMapping("/{id}")
    @Secured("ROLE_USER")
    public ProductModel getProductById(@PathVariable Long id){
        return userService.getProductById(id);
    }

    @PostMapping("/addproduct")
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    public String addProduct(@RequestBody ProductModel productModel){
        return userService.addProduct(productModel);
    }

    @GetMapping("/productbyuserid/{id}")
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    public List<ProductModel> getAllProductsByUserId(@PathVariable Long id){
        return userService.getAllProductsByUserId(id);
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }
}
