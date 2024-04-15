package com.example.spring_phoneshop.mapper;

import com.example.spring_backend_ecommerce.entity.Cart;
import com.example.spring_backend_ecommerce.entity.Review;
import com.example.spring_backend_ecommerce.model.dto.ReviewDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
public class ReviewMapper {
    @Autowired
    private ModelMapper modelMapper;
    public ReviewDTO toreviewDTO(Review review){
        ReviewDTO reviewDTO = modelMapper.map(review, ReviewDTO.class);
        return reviewDTO;
    }
}