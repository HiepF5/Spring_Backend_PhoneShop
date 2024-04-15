package com.example.spring_phoneshop.restcontroller;

import com.example.spring_backend_ecommerce.entity.User;
import com.example.spring_backend_ecommerce.model.dto.UserDTO;
import com.example.spring_backend_ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserRestController {
    @Autowired
    private UserService userService;
    @GetMapping("/user")
    public List<UserDTO> getAllUser(){
        return userService.getAllUser();
    }
    @GetMapping("/user/{id}")
    public Optional<UserDTO> getUserById(@PathVariable Integer id){return userService.getUserById(id);}
    @PostMapping("/user")
    public void addUser(@RequestBody User user){userService.addUser(user);}
    @PutMapping ("/user")
    public void updateUser(@RequestBody User user){userService.updateUser(user);}
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Integer id){userService.deleteUser(id);}
}
