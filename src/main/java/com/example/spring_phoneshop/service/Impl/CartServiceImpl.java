package com.example.spring_phoneshop.service.Impl;

import com.example.spring_phoneshop.entity.Cart;
import com.example.spring_phoneshop.exception.NotFoundException;
import com.example.spring_phoneshop.dto.CartDTO;
import com.example.spring_phoneshop.mapper.CartMapper;
import com.example.spring_phoneshop.repository.CartRepository;
import com.example.spring_phoneshop.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    @Override
    public List<CartDTO> getAllCart() {
        List<Cart> cartList = cartRepository.findAll();
        List<CartDTO> cartDTOList = cartList.stream().map(element -> cartMapper.mapToCartDTO(element)).collect(Collectors.toList());
        return cartDTOList;
    }

    @Override
    public CartDTO getCartById(Integer id) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Không tìm thấy Cart với ID: " + id));
        CartDTO cartDTO = cartMapper.mapToCartDTO(cart);
        return cartDTO;
    }

    @Override
    public CartDTO addCart(CartDTO cartDTO) {
        Cart cart = cartMapper.mapToCartEntity(cartDTO);
        Cart saveCart = cartRepository.save(cart);
        return cartMapper.mapToCartDTO(saveCart);
    }

    @Override
    public CartDTO updateCart(Integer cartId, CartDTO updateCart) {
        if (cartId == null || updateCart == null) {
            throw new IllegalArgumentException("productsId và updateProducts không được null");
        }
        Cart existingCart = cartRepository.findById(cartId)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy sản phẩm có ID: " + cartId));
        existingCart.setCartId(updateCart.getCartId());

        Cart saveCart = cartRepository.save(existingCart);
        return cartMapper.mapToCartDTO(saveCart);
    }
    @Override
    public void deleteCart(Integer cartId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(()-> new NotFoundException("Không tìm thấy employee có ID:"+ cartId));
        cartRepository.deleteById(cartId);
    }
}
