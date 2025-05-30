package com.example.pejon.model.dto;

public record CreateUserDto (
        Long id,
        String name,
        String login,
        String password,
        Long roleId
) {
}
