package com.example.spring_phoneshop.dto;

import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;

@Data
public class ReviewDTO {
    private Date date;
    private Integer productsId;
    private Integer rate;
    private Integer reviewId;
    private Integer userId;
    private String comment;

}
