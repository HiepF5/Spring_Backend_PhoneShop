package com.example.spring_phoneshop.repository;

import com.example.spring_backend_ecommerce.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer>{
    List<Cart> findAll();

    Optional<Cart> findById(Integer integer);
}
