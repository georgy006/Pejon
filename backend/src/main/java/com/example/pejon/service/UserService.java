package com.example.pejon.service;

import com.example.pejon.model.User;
import com.example.pejon.model.dto.CreateUserDto;
import com.example.pejon.model.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto getUserById(Long id);

    List<UserDto> getUsers();

    UserDto createUser(CreateUserDto user);

    UserDto updateUserById(Long id, User user);
}
