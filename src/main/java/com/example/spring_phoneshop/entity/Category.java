package com.example.spring_phoneshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryId", nullable = false, unique = true)
    private Integer categoryId;
    @Column(name ="categoryName", nullable = false)
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private Set<Products> products;

}
