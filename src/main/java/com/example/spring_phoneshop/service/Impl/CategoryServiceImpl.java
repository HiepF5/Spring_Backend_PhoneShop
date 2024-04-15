package com.example.spring_phoneshop.service.Impl;

import com.example.spring_backend_ecommerce.entity.Category;
import com.example.spring_backend_ecommerce.exception.NotFoundException;
import com.example.spring_backend_ecommerce.model.dto.CategoryDTO;
import com.example.spring_backend_ecommerce.model.mapper.CategoryMapper;
import com.example.spring_backend_ecommerce.repository.CategoryRepository;
import com.example.spring_backend_ecommerce.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOList = categoryList.stream().map(element -> categoryMapper.tocategoryDTO(element)).collect(Collectors.toList());
        return categoryDTOList;
    }

    @Override
    public Optional<CategoryDTO> getCategoryById(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy Category với ID: "+ id));
        CategoryDTO categoryDTO = categoryMapper.tocategoryDTO(category);
        return Optional.of(categoryDTO);
    }

    @Override
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }
}
