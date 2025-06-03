package com.example.pejon.model.dto.auth_dto;

public record RegisterRequest(
        String name,
        String login,
        String password,
        Long roleId
) {
}
