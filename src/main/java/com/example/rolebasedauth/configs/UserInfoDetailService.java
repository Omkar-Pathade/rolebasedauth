package com.example.rolebasedauth.configs;


import com.example.rolebasedauth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.example.rolebasedauth.entities.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(username);
        return user.map(UserInfoDetails::new).orElseThrow(()->new UsernameNotFoundException("User not found with "+username));
    }
}
