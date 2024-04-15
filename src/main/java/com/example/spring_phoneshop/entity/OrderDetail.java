package com.example.spring_phoneshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderdetailId", nullable = false, unique = true)
    private Integer orderdetailId;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    @Column(name = "status", nullable = false)
    private Integer status;
    @Column(name = "price", nullable = false)
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName ="cartId")
    private Cart cart;

//    @ManyToOne
//    @JoinColumn(name = "clothes_id", referencedColumnName ="clothesId")
//    private Clothes clothes;
//
//    @ManyToOne
//    @JoinColumn(name = "orders_id", referencedColumnName ="ordersId")
//    private Orders orders;

}