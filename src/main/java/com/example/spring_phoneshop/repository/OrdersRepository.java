package com.example.spring_phoneshop.repository;

import com.example.spring_phoneshop.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    @Query("SELECT o FROM Orders o WHERE FUNCTION('MONTH', o.date) = :month")
    List<Orders> findOrdersByMonth(@Param("month") int month);

//    @Query("SELECT o FROM Orders o WHERE o.user.userId = :userId")
//    List<Orders> findByUserId(Integer userId);
    @Query("SELECT COUNT(o) FROM Orders o")
    int countAllOrders();
    @Query("SELECT SUM(o.total) FROM Orders o")
    int getTotalOrderAmount();
    @Query("SELECT MONTH(o.date) FROM Orders o GROUP BY MONTH(o.date) ORDER BY COUNT(o.ordersId) DESC LIMIT 1")
    int findMonthWithMostOrders();
}
