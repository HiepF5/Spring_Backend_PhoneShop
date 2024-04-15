package com.example.spring_phoneshop.repository;

import com.example.spring_backend_ecommerce.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    List<Orders> findAll();

    Optional<Orders> findById(Integer integer);
}
