package com.example.spring_phoneshop.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Integer userId;
    private String address;
    private String email;
    private String fullName;
    private String phoneNumber;
    private String username;

}
