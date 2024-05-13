package com.example.spring_phoneshop.service;

import com.example.spring_phoneshop.entity.Review;
import com.example.spring_phoneshop.dto.ReviewDTO;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<ReviewDTO> getAllReview();

    Optional<ReviewDTO> getReviewById(Integer id);

    void addReview(Review review);

    void updateReview(Review review);

    void deleteReview(Integer id);
}
