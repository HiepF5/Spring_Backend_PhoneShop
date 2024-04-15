package com.example.spring_phoneshop.restcontroller;

import com.example.spring_backend_ecommerce.entity.Category;
import com.example.spring_backend_ecommerce.model.dto.CategoryDTO;
import com.example.spring_backend_ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CategoryRestController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public List<CategoryDTO> getAllCategory(){
        return categoryService.getAllCategory();
    }
    @GetMapping("/category/{id}")
    public Optional<CategoryDTO> getCategoryById(@PathVariable Integer id){return categoryService.getCategoryById(id);}
    @PostMapping("/category")
    public void addCategory(@RequestBody Category category){categoryService.addCategory(category);}
    @PutMapping ("/category")
    public void updateCategory(@RequestBody Category category){categoryService.updateCategory(category);}
    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable Integer id){categoryService.deleteCategory(id);}
}
