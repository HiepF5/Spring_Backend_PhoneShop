package com.example.spring_phoneshop.response;

import com.example.spring_phoneshop.dto.RoleDTO;
import com.example.spring_phoneshop.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class LoginResponse {
    private Integer  id;
    private String  username;
    private List<RoleDTO> role;
    private String accessToken;
    private String refreshToken;
}
