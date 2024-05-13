package com.example.spring_phoneshop.service;
import com.example.spring_phoneshop.dto.ProductsDTO;

import java.util.List;
public interface ProductsService {
    List<ProductsDTO> getAllProducts();
    ProductsDTO getProductsById(Integer id);
    ProductsDTO addProducts(ProductsDTO productsDTO);
    List<ProductsDTO> addProductsList(List<ProductsDTO> productsDTOList);
    ProductsDTO updateProducts(Integer productsId,  ProductsDTO updateProducts);
    void deleteProducts(Integer productsId);

}
