package com.example.pejon.model.dto.user_dto;

import com.example.pejon.model.Role;

public record UserDto(
        Long id,
        String name,
        String login,
        Role role
) {
}
