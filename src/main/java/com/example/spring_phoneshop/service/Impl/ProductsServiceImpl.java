package com.example.spring_phoneshop.service.Impl;

import com.example.spring_phoneshop.dto.ProductsDTO;
import com.example.spring_phoneshop.entity.Products;
import com.example.spring_phoneshop.exception.NotFoundException;
import com.example.spring_phoneshop.mapper.ProductsMapper;
import com.example.spring_phoneshop.repository.ProductsRepository;
import com.example.spring_phoneshop.service.ProductsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductsServiceImpl implements ProductsService {
    private final ProductsRepository productsRepository;
    private final ProductsMapper productsMapper;

    public List<ProductsDTO> getAllProducts() {
        List<Products> productsList = productsRepository.findAll();
        List<ProductsDTO> productsDTOList = productsList.stream().map(element -> productsMapper.mapToProductsDTO(element)).collect(Collectors.toList());
        return productsDTOList;
    }
    public ProductsDTO getProductsById(Integer id) {
        Products products = productsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy Product với ID: " + id));
        ProductsDTO productsDTO = productsMapper.mapToProductsDTO(products);
        return productsDTO;
    }


    @Override
    public ProductsDTO addProducts(ProductsDTO productsDTO) {
        Products products = productsMapper.mapToProductsEntity(productsDTO);
        Products saveProducts = productsRepository.save(products);
        return productsMapper.mapToProductsDTO(saveProducts);
    }

    @Override
    public List<ProductsDTO> addProductsList(List<ProductsDTO> productsDTOList) {
        List<Products> productsList = productsDTOList.stream()
                .map(productsMapper::mapToProductsEntity)
                .collect(Collectors.toList());

        List<Products> savedProductsList = productsRepository.saveAll(productsList);

        return savedProductsList.stream()
                .map(productsMapper::mapToProductsDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductsDTO updateProducts(Integer productsId, ProductsDTO updateProducts) {
        if (productsId == null || updateProducts == null) {
            throw new IllegalArgumentException("productsId và updateProducts không được null");
        }
        Products existingProducts = productsRepository.findById(productsId)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy sản phẩm có ID: " + productsId));
        existingProducts.setProductsName(updateProducts.getProductsName());
        existingProducts.setDescription(updateProducts.getDescription());
        existingProducts.setBrand(updateProducts.getBrand());
        existingProducts.setImage(updateProducts.getImage());
        existingProducts.setImage2(updateProducts.getImage2());
        existingProducts.setImage3(updateProducts.getImage3());
        existingProducts.setImage4(updateProducts.getImage4());
        existingProducts.setPrice(updateProducts.getPrice());
        existingProducts.setQuantity(updateProducts.getQuantity());
        existingProducts.setSold(updateProducts.getSold());
        Products saveProducts = productsRepository.save(existingProducts);
        return productsMapper.mapToProductsDTO(saveProducts);
        //Cach update khac
        //Employee employee =employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Không tìm thấy employee có ID:"+ employeeId));
        //employee.setFirstName(updateEmployee.getFirstName());
        //employee.setLastName(updateEmployee.getLastName());
        //employee.setEmail(updateEmployee.getEmail());
    }
    @Override
    public void deleteProducts(Integer productsId) {
        Products products = productsRepository.findById(productsId)
                .orElseThrow(()-> new NotFoundException("Không tìm thấy employee có ID:"+ productsId));
        productsRepository.deleteById(productsId);
    }

}
