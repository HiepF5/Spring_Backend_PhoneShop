package com.example.spring_phoneshop.dto;

import com.example.spring_phoneshop.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserDTO {
    private Integer userId;
    private String address;
    private String email;
    private String fullName;
    private String phoneNumber;
    private String username;
    private List<RoleDTO> role;
}
