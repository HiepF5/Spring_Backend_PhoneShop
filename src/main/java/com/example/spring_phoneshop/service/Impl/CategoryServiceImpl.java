package com.example.spring_phoneshop.service.Impl;

import com.example.spring_phoneshop.dto.ProductsDTO;
import com.example.spring_phoneshop.entity.Category;
import com.example.spring_phoneshop.entity.Products;
import com.example.spring_phoneshop.exception.NotFoundException;
import com.example.spring_phoneshop.dto.CategoryDTO;
import com.example.spring_phoneshop.mapper.CategoryMapper;
import com.example.spring_phoneshop.repository.CategoryRepository;
import com.example.spring_phoneshop.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
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
        List<CategoryDTO> categoryDTOList = categoryList.stream().map(element -> categoryMapper.mapToCategoryDTO(element)).collect(Collectors.toList());
        return categoryDTOList;
    }

    @Override
    public CategoryDTO getCategoryById(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy Category với ID: "+ id));
        CategoryDTO categoryDTO = categoryMapper.mapToCategoryDTO(category);
        return categoryDTO;
    }
    @Override
    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
        Category category = categoryMapper.mapToCategoryEntity(categoryDTO);
        Category saveCategory = categoryRepository.save(category);
        return categoryMapper.mapToCategoryDTO(saveCategory);
    }
    @Override
    public CategoryDTO updateCategory(Integer categoryId, CategoryDTO updateCategory) {
        if (categoryId == null || updateCategory == null) {
            throw new IllegalArgumentException("categoryId và updateCategory không được null");
        }
        Category existingCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy sản phẩm có ID: " + categoryId));
        existingCategory.setCategoryName(updateCategory.getCategoryName());
        Category saveCategory = categoryRepository.save(existingCategory);
        return categoryMapper.mapToCategoryDTO(saveCategory);
    }
    @Override
    public void deleteCategory(Integer categoryId) {
        Category category  = categoryRepository.findById(categoryId)
                .orElseThrow(()-> new NotFoundException("Không tìm thấy Category có ID:"+ categoryId));
        categoryRepository.deleteById(categoryId);
    }
}
