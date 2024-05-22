package com.example.spring_phoneshop.restcontroller;

import com.example.spring_phoneshop.request.LoginRequest;
import com.example.spring_phoneshop.request.RegisterRequest;
import com.example.spring_phoneshop.response.LoginResponse;
import com.example.spring_phoneshop.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthRestController {
    @Autowired
    private AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) throws Exception {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(authService.login(request));
    }
    @PostMapping("/register")
    public ResponseEntity<LoginResponse> register(@RequestBody RegisterRequest request) throws Exception {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(authService.register(request));
    }
}
