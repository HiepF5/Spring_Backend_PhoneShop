package com.example.spring_phoneshop.restcontroller;


import com.example.spring_phoneshop.dto.CartDTO;
import com.example.spring_phoneshop.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CartRestController {
    @Autowired
    private CartService cartService;
    @GetMapping("/cart")
    public ResponseEntity<List<CartDTO>> getAllCart(){
        List<CartDTO> cartDTOS = cartService.getAllCart();
        return ResponseEntity.ok(cartDTOS);
    }
    @GetMapping("/cart/{id}")
    public ResponseEntity<CartDTO> getCartById(@PathVariable("id") Integer cartId){
        CartDTO cartDTO = cartService.getCartById(cartId);
        return ResponseEntity.ok(cartDTO);
    }
    @PostMapping("/cart")
    public ResponseEntity<CartDTO> addCart(@RequestBody CartDTO cartDTO) {
        CartDTO saveCart = cartService.addCart(cartDTO);
        return new ResponseEntity<>(saveCart, HttpStatus.CREATED);
    }
    @PutMapping("/cart/{id}")
    public ResponseEntity<CartDTO> updateCart(@PathVariable("id") Integer cartId,
                                                      @RequestBody CartDTO updateCart){
        CartDTO cartDTO = cartService.updateCart(cartId, updateCart);
        return ResponseEntity.ok(cartDTO);
    }
    @DeleteMapping("/cart/{id}")
    public ResponseEntity<String> deleteCart(@PathVariable("id") Integer cartId) {
        cartService.deleteCart(cartId);
        return ResponseEntity.ok("Product deleted successfully!");
    }
}
