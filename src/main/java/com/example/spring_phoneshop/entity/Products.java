package com.example.spring_phoneshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name ="products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="productsId", nullable = false, unique = true)
    private Integer productsId;
    @Column(name="productsName",  nullable = false)
    private String productsName;
    @Column(name = "description",  nullable = false)
    private String description;
    @Column(name ="brand",  nullable = false)
    private String brand;
    @Column(name = "image",  nullable = false)
    private String image;
    @Column(name = "image2",  nullable = false)
    private String image2;
    @Column(name = "image3",  nullable = false)
    private String image3;
    @Column(name = "image4",  nullable = false)
    private String image4;
    @Column(name= "price", nullable = false)
    private Integer price;
    @Column(name= "quantity", nullable = false)
    private Integer quantity;
    @Column(name = "sold", nullable = false)
    private Integer sold;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName ="categoryId")
    private Category category;

    @OneToMany(mappedBy = "products")
    private Set<Review> reviews;

    @OneToMany(mappedBy = "products")
    private Set<OrderDetail> orderdetail;


}
