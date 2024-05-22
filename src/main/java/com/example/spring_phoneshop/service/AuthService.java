package com.example.spring_phoneshop.service;

import com.example.spring_phoneshop.request.LoginRequest;
import com.example.spring_phoneshop.request.RegisterRequest;
import com.example.spring_phoneshop.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest request) throws Exception;
    LoginResponse register(RegisterRequest request) throws Exception;
}
