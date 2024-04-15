package com.example.spring_phoneshop.service.Impl;

import com.example.spring_backend_ecommerce.entity.Cart;
import com.example.spring_backend_ecommerce.exception.NotFoundException;
import com.example.spring_backend_ecommerce.model.dto.CartDTO;
import com.example.spring_backend_ecommerce.model.mapper.CartMapper;
import com.example.spring_backend_ecommerce.repository.CartRepository;
import com.example.spring_backend_ecommerce.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    @Override
    public List<CartDTO> getAllCart() {
        List<Cart> cartList = cartRepository.findAll();
        List<CartDTO> cartDTOList = cartList.stream().map(element -> cartMapper.toCartDTO(element)).collect(Collectors.toList());
        return cartDTOList;
    }

    @Override
    public Optional<CartDTO> getCartById(Integer id) {
        Cart cart = cartRepository.findById(id).orElseThrow(()-> new NotFoundException("Không tìm thấy Cart với ID: " + id));
        CartDTO cartDTO = cartMapper.toCartDTO(cart);
        return Optional.of(cartDTO);
    }

    @Override
    public void addCart(Cart cart) {
        cartRepository.save(cart);

    }

    @Override
    public void updateCart(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public void deleteCart(Integer id) {
        cartRepository.deleteById(id);
    }
}
