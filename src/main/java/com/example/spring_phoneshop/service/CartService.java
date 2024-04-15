package com.example.spring_phoneshop.service;

import com.example.spring_backend_ecommerce.entity.Cart;
import com.example.spring_backend_ecommerce.model.dto.CartDTO;

import java.util.List;
import java.util.Optional;

public interface CartService {
    List<CartDTO> getAllCart();

    Optional<CartDTO> getCartById(Integer id);

    void addCart(Cart cart);
    void updateCart(Cart cart);
    void deleteCart(Integer id);
}
