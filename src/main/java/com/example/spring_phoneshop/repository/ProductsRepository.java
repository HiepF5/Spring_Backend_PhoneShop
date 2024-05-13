package com.example.spring_phoneshop.repository;


import com.example.spring_phoneshop.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {

}
