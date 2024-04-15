package com.example.spring_phoneshop.restcontroller;

import com.example.spring_backend_ecommerce.entity.Review;
import com.example.spring_backend_ecommerce.model.dto.ReviewDTO;
import com.example.spring_backend_ecommerce.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ReviewRestController {
    @Autowired
    private ReviewService reviewService;
    @GetMapping("/review")
    public List<ReviewDTO> getAllReview(){
        return reviewService.getAllReview();
    }
    @GetMapping("/review/{id}")
    public Optional<ReviewDTO> getReviewById(@PathVariable Integer id){return reviewService.getReviewById(id);}
    @PostMapping("/review")
    public void addReview(@RequestBody Review review){reviewService.addReview(review);}
    @PutMapping ("/review")
    public void updateReview(@RequestBody Review review){reviewService.updateReview(review);}
    @DeleteMapping("/review/{id}")
    public void deleteReview(@PathVariable Integer id){reviewService.deleteReview(id);}
}
