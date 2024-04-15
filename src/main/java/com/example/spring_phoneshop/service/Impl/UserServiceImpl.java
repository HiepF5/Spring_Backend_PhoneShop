package com.example.spring_phoneshop.service.Impl;

import com.example.spring_backend_ecommerce.entity.User;
import com.example.spring_backend_ecommerce.exception.NotFoundException;
import com.example.spring_backend_ecommerce.model.dto.UserDTO;
import com.example.spring_backend_ecommerce.model.mapper.UserMapper;
import com.example.spring_backend_ecommerce.repository.UserRepository;
import com.example.spring_backend_ecommerce.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<User> userList = userRepository.findAll();

        List<UserDTO> userDTOList = userList.stream().map(element -> userMapper.touserDTO(element)).collect(Collectors.toList());

        return userDTOList;
    }

    @Override
    public Optional<UserDTO> getUserById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy User với ID: " + id));

        UserDTO userDTO = userMapper.touserDTO(user);
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
}
