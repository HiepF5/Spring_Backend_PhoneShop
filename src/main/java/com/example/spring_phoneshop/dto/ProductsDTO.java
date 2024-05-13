package com.example.spring_phoneshop.dto;

import lombok.Data;

@Data
public class ProductsDTO {
    private Integer price;
    private Integer productsId;
    private Integer quantity;
    private Integer sold;
    private String brand;
    private String description;
    private String image;
    private String image2;
    private String image3;
    private String image4;
    private String productsName;
}
