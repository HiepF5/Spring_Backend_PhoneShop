package com.example.spring_phoneshop.service;

import com.example.spring_backend_ecommerce.entity.Category;
import com.example.spring_backend_ecommerce.model.dto.CategoryDTO;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoryDTO> getAllCategory();

    Optional<CategoryDTO>getCategoryById(Integer id);

    void addCategory(Category category);

    void updateCategory(Category category);

    void deleteCategory(Integer id);
}
