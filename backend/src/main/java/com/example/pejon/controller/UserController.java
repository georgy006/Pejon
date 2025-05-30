package com.example.pejon.controller;

import com.example.pejon.model.User;
import com.example.pejon.model.dto.user_dto.UserCreateDto;
import com.example.pejon.model.dto.user_dto.UserDto;
import com.example.pejon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<UserDto> getAllUsers() {
        return userService.getUsers();
    }
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    @PostMapping("/")
    public UserDto createUser(@RequestBody UserCreateDto user) {
        return userService.createUser(user);
    }
    @PostMapping("/{id}")
    public UserDto updateUserById(@PathVariable Long id, @RequestBody UserCreateDto userCreateDto) {
        return userService.updateUserById(id, userCreateDto);
    }
}
