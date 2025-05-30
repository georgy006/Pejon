package com.example.pejon.model.dto.user_dto;

public record UserCreateDto(
        Long id,
        String name,
        String login,
        String password,
        Long roleId
) {
}
