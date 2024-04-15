package com.example.spring_phoneshop.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component


public class CartMapper {
    @Autowired
    private ModelMapper modelMapper;
    public CartDTO toCartDTO(Cart cart){
        CartDTO cartDTO = modelMapper.map(cart, CartDTO.class);
        return cartDTO;
    }
    public Cart toCart(CartDTO cartDTO){
        Cart cart = modelMapper.map(cartDTO, Cart.class);
        return cart;
    }
}