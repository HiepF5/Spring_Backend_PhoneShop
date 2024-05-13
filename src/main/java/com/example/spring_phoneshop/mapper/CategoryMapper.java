package com.example.spring_phoneshop.mapper;



import com.example.spring_phoneshop.dto.CategoryDTO;
import com.example.spring_phoneshop.dto.ProductsDTO;
import com.example.spring_phoneshop.entity.Category;
import com.example.spring_phoneshop.entity.Products;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
public class CategoryMapper {
    @Autowired
    private ModelMapper modelMapper;
    public CategoryDTO mapToCategoryDTO(Category category){
        CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
        return categoryDTO;
    }
    public Category mapToCategoryEntity (CategoryDTO categoryDTO){
        Category category = modelMapper.map(categoryDTO, Category.class);
        return category;
    }

}
