package com.example.spring_phoneshop.mapper;

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
    public ClothesDTO toclothesDTO(Clothes clothes){
        ClothesDTO clothesDTO = modelMapper.map(clothes, ClothesDTO.class);
        return clothesDTO;
    }
    //DTO to Entity
    public Clothes toClothesEntity (ClothesDTO clothesDTO){
        Clothes clothes = modelMapper.map(clothesDTO, Clothes.class);
        return clothes;
    }
}