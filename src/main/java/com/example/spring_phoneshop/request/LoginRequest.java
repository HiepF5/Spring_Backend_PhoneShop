package com.example.spring_phoneshop.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
