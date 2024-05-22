package com.example.spring_phoneshop.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterRequest {
    private String address;
    private String email;
    private String fullName;
    private String phoneNumber;
    private String username;
    private  String password;
}
