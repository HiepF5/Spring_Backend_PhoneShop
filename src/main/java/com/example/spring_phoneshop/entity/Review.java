package com.example.spring_phoneshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "review")

public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewId", nullable = false, unique = true)
    private Integer reviewId;
    @Column(name = "comment", nullable = false)
    private String comment;
    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "rate", nullable = false)
    private Integer rate;

    @ManyToOne
    @JoinColumn(name = "products_Id", referencedColumnName ="productsId")
    private Products products;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName ="userId")
    private User user;


}
