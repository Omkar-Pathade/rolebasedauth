package com.example.rolebasedauth.repositories;

import com.example.rolebasedauth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
