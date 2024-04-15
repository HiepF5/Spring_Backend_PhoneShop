package com.example.spring_phoneshop.mapper;



import com.example.spring_phoneshop.dto.CategoryDTO;
import com.example.spring_phoneshop.entity.Category;
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
    public CategoryDTO tocategoryDTO(Category category){
        CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
        return categoryDTO;
    }

}
