package com.example.spring_phoneshop.service;


import com.example.spring_phoneshop.dto.CategoryDTO;
import com.example.spring_phoneshop.dto.ProductsDTO;
import com.example.spring_phoneshop.entity.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAllCategory();
    CategoryDTO getCategoryById(Integer id);

    CategoryDTO addCategory(CategoryDTO categoryDTO);

    CategoryDTO updateCategory(Integer categoryId, CategoryDTO updateCategory);
    void deleteCategory(Integer categoryId);
}
