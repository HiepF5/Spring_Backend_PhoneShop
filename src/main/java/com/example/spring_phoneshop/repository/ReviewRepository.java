package com.example.spring_phoneshop.repository;

import com.example.spring_phoneshop.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findAll();

    Optional<Review> findById(Integer integer);
}
