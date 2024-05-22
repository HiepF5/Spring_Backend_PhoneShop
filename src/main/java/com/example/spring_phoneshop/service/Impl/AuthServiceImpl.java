package com.example.spring_phoneshop.service.Impl;

import com.example.spring_phoneshop.dto.RoleDTO;
import com.example.spring_phoneshop.dto.UserDTO;
import com.example.spring_phoneshop.entity.Role;
import com.example.spring_phoneshop.entity.User;
import com.example.spring_phoneshop.mapper.RoleMapper;
import com.example.spring_phoneshop.repository.RoleRepository;
import com.example.spring_phoneshop.repository.UserRepository;
import com.example.spring_phoneshop.request.LoginRequest;
import com.example.spring_phoneshop.request.RegisterRequest;
import com.example.spring_phoneshop.response.LoginResponse;
import com.example.spring_phoneshop.security.CustomUserDetail;
import com.example.spring_phoneshop.security.JWTProvider;
import com.example.spring_phoneshop.service.AuthService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTProvider jwtProvider;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    private final RoleMapper roleMapper;

    @Override
    public LoginResponse login(LoginRequest request) throws Exception {
        if(!userRepository.existsByUsername(request.getUsername())) {
            throw new Exception("Username not found");
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));
        if (authentication.isAuthenticated()) {
            CustomUserDetail userDetails = (CustomUserDetail) authentication.getPrincipal();
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String accessToken = jwtProvider.generateToken(authentication.getName());
            String refreshToken = jwtProvider.generateRefreshToken(userDetails.getId() + "");
            return new LoginResponse(
                    userDetails.getId(),
                    userDetails.getUsername(),
                    userDetails.getRoles().stream().map(roleMapper::mapToRoleDTO).collect(Collectors.toList()),
                    accessToken,
                    refreshToken
            );
        }
        return null;
    }

    @Override
    @Transactional
    public LoginResponse register(RegisterRequest registerRequest) throws Exception {
        if (userRepository.existsByUsername(registerRequest.getUsername())
                || userRepository.existsByEmail(registerRequest.getEmail())) {
           throw new Exception("Username or email is existed");

        }

        else {
            User customer = new User();
            customer.setUsername(registerRequest.getUsername());
            customer.setFullName(registerRequest.getFullName());
            customer.setEmail(registerRequest.getEmail());
            customer.setAddress(registerRequest.getAddress());
            customer.setPhoneNumber(registerRequest.getPhoneNumber());

            customer.setPassword(passwordEncoder.encode((registerRequest.getPassword())));
            Role role = roleRepository.findByRoleName("CUSTOMER").get();
            customer.setRoles(Collections.singleton(role));
            userRepository.save(customer);
            String accessToken = jwtProvider.generateToken(registerRequest.getUsername());
            String refreshToken = jwtProvider.generateRefreshToken(customer.getUserId() + "");
            return new LoginResponse(

                            customer.getUserId(),
                            customer.getUsername(),
                            customer.getRoles().stream().map(roleMapper::mapToRoleDTO).collect(Collectors.toList()),
                    accessToken,
                    refreshToken
            );
        }
    }
}
