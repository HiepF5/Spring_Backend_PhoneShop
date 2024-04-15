package com.example.spring_phoneshop.service.Impl;

import com.example.spring_phoneshop.entity.Products;
import com.example.spring_phoneshop.exception.NotFoundException;
import com.example.spring_phoneshop.dto.ProductsDTO;
import com.example.spring_phoneshop.mapper.ProductsMapper;
import com.example.spring_phoneshop.repository.ProductsRepository;
import com.example.spring_phoneshop.service.ClothesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClothesServiceImpl implements ClothesService {
    private final ClothesRepository clothesRepository;
    private final ClothesMapper clothesMapper;

    public ClothesServiceImpl(ClothesRepository clothesRepository, ClothesMapper clothesMapper)
    {
        this.clothesRepository=clothesRepository;
        this.clothesMapper = clothesMapper;
    }

    public List<ClothesDTO> getAllClothes() {
        List<Clothes> clothesList = clothesRepository.findAll();

        List<ClothesDTO> clothesDTOList = clothesList.stream().map(element -> clothesMapper.toclothesDTO(element)).collect(Collectors.toList());

        return clothesDTOList;
    }
    public Optional<ClothesDTO> getClothesById(Integer id) {
        Clothes clothes = clothesRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy Clothes với ID: " + id));

        ClothesDTO clothesDTO = clothesMapper.toclothesDTO(clothes);
        return Optional.of(clothesDTO);
    }


    @Override
    public void addClothes(Clothes clothes) {
        clothesRepository.save(clothes);
    }

    @Override
    public void updateClothes(Clothes clothes) {
        clothesRepository.save(clothes);
    }
    @Override
    public void deleteClothes(Integer id) {
        clothesRepository.deleteById(id);
    }

}
