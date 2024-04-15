package com.example.spring_phoneshop.repository;

import com.example.spring_backend_ecommerce.entity.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClothesRepository extends JpaRepository<Clothes, Integer>{
    List<Clothes>findAll();

    Optional<Clothes> findById(Integer integer);
}
