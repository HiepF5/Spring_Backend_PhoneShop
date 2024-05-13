package com.example.spring_phoneshop.service.Impl;


import com.example.spring_phoneshop.dto.Top5UserOrder;
import com.example.spring_phoneshop.entity.User;
import com.example.spring_phoneshop.exception.NotFoundException;
import com.example.spring_phoneshop.dto.UserDTO;
import com.example.spring_phoneshop.mapper.UserMapper;
import com.example.spring_phoneshop.repository.UserRepository;
import com.example.spring_phoneshop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDTO> getAllUser() {
        List<User> userList = userRepository.findAll();

        List<UserDTO> userDTOList = userList.stream().map(element -> userMapper.mapToUserDTO(element)).collect(Collectors.toList());

        return userDTOList;
    }

    @Override
    public Optional<UserDTO> getUserById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy User với ID: " + id));

        UserDTO userDTO = userMapper.mapToUserDTO(user);
        return Optional.of(userDTO);
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<Top5UserOrder> findTopFiveUsersByOrderCount() {
        return userRepository.findTopFiveUsersByOrderCount();
    }

    @Override
    public long getTotalUsers() {
        return userRepository.count();
    }


}
