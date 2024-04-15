package com.example.spring_phoneshop.restcontroller;

import com.example.spring_backend_ecommerce.entity.Cart;
import com.example.spring_backend_ecommerce.model.dto.CartDTO;
import com.example.spring_backend_ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CartRestController {
    @Autowired
    private CartService cartService;
    @GetMapping("/cart")
    public List<CartDTO> getAllCart(){
        return cartService.getAllCart();
    }
    @GetMapping("/cart/{id}")
    public Optional<CartDTO> getCartById(@PathVariable Integer id){return cartService.getCartById(id);}
    @PostMapping("/cart")
    public void addCart(@RequestBody Cart cart){cartService.addCart(cart);}
    @PutMapping ("/cart")
    public void updateCart(@RequestBody Cart cart){cartService.updateCart(cart);}
    @DeleteMapping("/cart/{id}")
    public void deleteCart(@PathVariable Integer id){cartService.deleteCart(id);}
}
