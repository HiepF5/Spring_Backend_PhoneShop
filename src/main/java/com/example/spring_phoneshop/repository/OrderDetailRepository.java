package com.example.spring_phoneshop.repository;

import com.example.spring_backend_ecommerce.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderdetailRepository extends JpaRepository<OrderDetail,Integer> {
    List<OrderDetail> findAll();

    Optional<OrderDetail> findById(Integer integer);
}
