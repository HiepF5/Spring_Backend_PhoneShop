package com.example.spring_phoneshop.mapper;

import com.example.spring_phoneshop.dto.ProductsDTO;
import com.example.spring_phoneshop.entity.Products;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
public class ProductsMapper {
    @Autowired
    private ModelMapper modelMapper;
    //Entity to DTO
    public ProductsDTO mapToProductsDTO(Products products){
        ProductsDTO productsDTO = modelMapper.map(products, ProductsDTO.class);
        return productsDTO;
    }
    //DTO to Entity
    public Products mapToProductsEntity (ProductsDTO productsDTO){
        Products products = modelMapper.map(productsDTO, Products.class);
        return products;
    }
}