package com.example.spring_phoneshop.service.Impl;

import com.example.spring_backend_ecommerce.entity.Review;
import com.example.spring_backend_ecommerce.exception.NotFoundException;
import com.example.spring_backend_ecommerce.model.dto.ReviewDTO;
import com.example.spring_backend_ecommerce.model.mapper.ReviewMapper;
import com.example.spring_backend_ecommerce.repository.ReviewRepository;
import com.example.spring_backend_ecommerce.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    public ReviewServiceImpl(ReviewRepository reviewRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
    }

    @Override
    public List<ReviewDTO> getAllReview() {
        List<Review> reviewList = reviewRepository.findAll();

        List<ReviewDTO> reviewDTOList = reviewList.stream().map(element -> reviewMapper.toreviewDTO(element)).collect(Collectors.toList());

        return reviewDTOList;
    }

    @Override
    public Optional<ReviewDTO> getReviewById(Integer id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy Review với ID: " + id));

        ReviewDTO reviewDTO = reviewMapper.toreviewDTO(review);
        return Optional.of(reviewDTO);
    }

    @Override
    public void addReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void updateReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void deleteReview(Integer id) {
        reviewRepository.deleteById(id);

    }
}

