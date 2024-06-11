package com.example.spring_phoneshop.repository;

import com.example.spring_phoneshop.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer> {

    @Query("SELECT od.products.productsId,od.products.productsName,od.products.image,od.products.price, SUM(od.quantity) FROM OrderDetail od GROUP BY od.products.productsId ORDER BY SUM(od.quantity) DESC")
    List<Object[]> findTotalQuantityForEachProduct();
}
