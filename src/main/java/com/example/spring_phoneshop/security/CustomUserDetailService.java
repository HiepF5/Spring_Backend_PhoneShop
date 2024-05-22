package com.example.spring_phoneshop.security;


import com.example.spring_phoneshop.entity.User;
import com.example.spring_phoneshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) {
        if(userRepository.existsByUsername(username)) {
            User user = userRepository.findByUsername(username).get();
            return CustomUserDetail.build(user);
        }
        throw new UsernameNotFoundException("Username is not found");
    }
}

