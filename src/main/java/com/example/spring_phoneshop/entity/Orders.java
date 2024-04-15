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
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ordersId", nullable = false, unique = true)
    private Integer ordersId;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "status", nullable = false)
    private Integer status;
    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;
    @Column(name = "username", nullable = false)
    private String username;

//    @OneToMany(mappedBy = "orders")
//    private Set<OrderDetail> orderDetails;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName ="userId")
//    private User user;



}
