package com.example.spring_phoneshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Top5UserOrder {
    private Integer userId;
    private String address;
    private String email;
    private String fullName;
    private String phoneNumber;
    private String username;
    private Long total_order;
}
