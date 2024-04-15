package com.example.spring_phoneshop.service;

import com.example.spring_backend_ecommerce.entity.User;
import com.example.spring_backend_ecommerce.model.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> getAllUser();

    Optional<UserDTO> getUserById(Integer id);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Integer id);
}

