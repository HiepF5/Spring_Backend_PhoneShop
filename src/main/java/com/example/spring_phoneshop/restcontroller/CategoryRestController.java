package com.example.spring_phoneshop.restcontroller;

import com.example.spring_phoneshop.dto.CategoryDTO;
import com.example.spring_phoneshop.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CategoryRestController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/category")
    public ResponseEntity<List<CategoryDTO>> getAllCategory(){
        List<CategoryDTO> categoryDTOS = categoryService.getAllCategory();
        return ResponseEntity.ok(categoryDTOS);
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable("id") Integer categoryId){
        CategoryDTO categoryDTO = categoryService.getCategoryById(categoryId);
        return ResponseEntity.ok(categoryDTO);
    }
    @PostMapping("/category")
    public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryDTO saveCategory = categoryService.addCategory(categoryDTO);
        return new ResponseEntity<>(saveCategory, HttpStatus.CREATED);
    }
    @PutMapping("/category/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable("id") Integer categoryId,
                                                      @RequestBody CategoryDTO updateCategory){
        CategoryDTO categoryDTO = categoryService.updateCategory(categoryId, updateCategory);
        return ResponseEntity.ok(categoryDTO);
    }
    @DeleteMapping("/category/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Integer categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok("Product deleted successfully!");
    }
}
