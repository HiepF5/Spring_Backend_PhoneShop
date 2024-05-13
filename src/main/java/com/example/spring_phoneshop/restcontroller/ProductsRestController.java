package com.example.spring_phoneshop.restcontroller;

import com.example.spring_phoneshop.dto.ProductsDTO;
import com.example.spring_phoneshop.service.ProductsService;
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
public class ProductsRestController {
    @Autowired
    private ProductsService productsService;
    @GetMapping("/products")
    public ResponseEntity<List<ProductsDTO>> getAllProducts(){
        List<ProductsDTO> productsDTOS = productsService.getAllProducts();
        return ResponseEntity.ok(productsDTOS);
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductsDTO> getProductsById(@PathVariable("id") Integer productsId){
        ProductsDTO productsDTO = productsService.getProductsById(productsId);
        return ResponseEntity.ok(productsDTO);
    }
    @PostMapping("/products")
    public ResponseEntity<ProductsDTO> addProducts(@RequestBody ProductsDTO productsDTO) {
        ProductsDTO saveProducts = productsService.addProducts(productsDTO);
        return new ResponseEntity<>(saveProducts, HttpStatus.CREATED);
    }
    @PostMapping("/products/addList")
    public ResponseEntity<List<ProductsDTO>> addProductsList(@RequestBody List<ProductsDTO> productsDTOList) {
        List<ProductsDTO> savedProductsList = productsService.addProductsList(productsDTOList);
        return new ResponseEntity<>(savedProductsList, HttpStatus.CREATED);
    }
    @PutMapping("/products/{id}")
    public ResponseEntity<ProductsDTO> updateProducts(@PathVariable("id") Integer productsId,
                                                      @RequestBody ProductsDTO updateProducts){
        ProductsDTO productsDTO = productsService.updateProducts(productsId, updateProducts);
        return ResponseEntity.ok(productsDTO);
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProducts(@PathVariable("id") Integer productsId) {
        productsService.deleteProducts(productsId);
        return ResponseEntity.ok("Product deleted successfully!");
    }
}
