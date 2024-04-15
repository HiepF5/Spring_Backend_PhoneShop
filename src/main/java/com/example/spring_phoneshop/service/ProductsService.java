package com.example.spring_phoneshop.service;

import com.example.spring_phoneshop.entity.Products;
import com.example.spring_phoneshop.dto.ProductsDTO;

import java.util.List;
import java.util.Optional;
public interface ClothesService {
    List<ProductsDTO> getAllClothes();

    Optional<ProductsDTO>getClothesById(Integer id);

    void addClothes(Products products);
    void updateClothes(Products products);
    void deleteClothes(Integer id);

}
