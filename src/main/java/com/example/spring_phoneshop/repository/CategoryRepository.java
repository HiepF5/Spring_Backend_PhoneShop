package com.example.spring_phoneshop.repository;

import com.example.spring_backend_ecommerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer > {
    List<Category> findAll();

    Optional<Category> findById(Integer integer);
}
