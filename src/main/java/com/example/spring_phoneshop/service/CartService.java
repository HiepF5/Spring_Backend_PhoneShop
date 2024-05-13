package com.example.spring_phoneshop.service;


import com.example.spring_phoneshop.dto.CartDTO;
import com.example.spring_phoneshop.dto.ProductsDTO;
import com.example.spring_phoneshop.entity.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {
    List<CartDTO> getAllCart();

    CartDTO getCartById(Integer id);

    CartDTO addCart(CartDTO cartDTO);
    CartDTO updateCart(Integer cartId, CartDTO updateCart);
    void deleteCart(Integer cartId);
}
