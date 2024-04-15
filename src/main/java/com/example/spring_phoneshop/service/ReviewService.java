package com.example.spring_phoneshop.service;

import com.example.spring_backend_ecommerce.entity.Review;
import com.example.spring_backend_ecommerce.model.dto.ReviewDTO;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<ReviewDTO> getAllReview();

    Optional<ReviewDTO> getReviewById(Integer id);

    void addReview(Review review);

    void updateReview(Review review);

    void deleteReview(Integer id);
}
