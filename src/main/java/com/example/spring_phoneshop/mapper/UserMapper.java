package com.example.spring_phoneshop.mapper;

import com.example.spring_phoneshop.dto.UserDTO;
import com.example.spring_phoneshop.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
public class UserMapper {
    @Autowired
    private ModelMapper modelMapper;
    public UserDTO touserDTO(User user){
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }
}