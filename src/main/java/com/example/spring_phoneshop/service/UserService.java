package com.example.spring_phoneshop.service;

import com.example.spring_phoneshop.dto.OrdersDTO;
import com.example.spring_phoneshop.dto.Top5UserOrder;
import com.example.spring_phoneshop.entity.User;
import com.example.spring_phoneshop.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> getAllUser();

    Optional<UserDTO> getUserById(Integer id);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Integer id);

    List<Top5UserOrder> findTopFiveUsersByOrderCount();

}

