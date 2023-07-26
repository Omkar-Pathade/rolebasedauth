package com.example.rolebasedauth.repositories;

import com.example.rolebasedauth.entities.Product;
import com.example.rolebasedauth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findAllByUser(User user);

}
