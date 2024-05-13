package com.example.spring_phoneshop.mapper;

import com.example.spring_phoneshop.dto.CartDTO;
import com.example.spring_phoneshop.dto.CategoryDTO;
import com.example.spring_phoneshop.entity.Cart;
import com.example.spring_phoneshop.entity.Category;
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

    public CartDTO mapToCartDTO(Cart cart){
        CartDTO cartDTO = modelMapper.map(cart, CartDTO.class);
        return cartDTO;
    }
    public Cart mapToCartEntity (CartDTO cartDTO){
        Cart cart = modelMapper.map(cartDTO, Cart.class);
        return cart;
    }
}