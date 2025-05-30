package com.example.pejon.service;

import com.example.pejon.model.dto.user_dto.UserCreateDto;
import com.example.pejon.model.dto.user_dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto getUserById(Long id);

    List<UserDto> getUsers();

    UserDto createUser(UserCreateDto userCreateDto);

    UserDto updateUserById(Long id, UserCreateDto userCreateDto);
}
