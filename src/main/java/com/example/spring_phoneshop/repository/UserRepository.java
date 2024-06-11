package com.example.spring_phoneshop.repository;

import com.example.spring_phoneshop.dto.Top5UserOrder;
import com.example.spring_phoneshop.entity.Products;
import com.example.spring_phoneshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT NEW com.example.spring_phoneshop.dto.Top5UserOrder(u.userId, u.address, u.email, u.fullName, u.phoneNumber, u.username, SUM(o.total)) " +
            "FROM User u " +
            "JOIN Orders o ON u.userId = o.user.userId " +
            "GROUP BY u.userId " +
            "ORDER BY SUM(o.total) DESC " +
            "LIMIT 5")
    List<Top5UserOrder> findTopFiveUsersByOrderCount();
    long count();
    Boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
    Boolean existsByEmail(String email);
    @Query("SELECT od.products FROM OrderDetail od JOIN od.orders o WHERE o.user.userId = :userId GROUP BY od.products.productsId ORDER BY SUM(od.quantity) DESC LIMIT 4")
    List<Products> findMostPurchasedProductsByUserId(@Param("userId") int userId);
}
