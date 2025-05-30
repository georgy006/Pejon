package com.example.pejon.service;

import com.example.pejon.model.User;
import com.example.pejon.model.dto.user_dto.UserCreateDto;
import com.example.pejon.model.dto.user_dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto getUserById(Long id);

    List<UserDto> getUsers();

    UserDto createUser(UserCreateDto user);

    UserDto updateUserById(Long id, User user);
}
