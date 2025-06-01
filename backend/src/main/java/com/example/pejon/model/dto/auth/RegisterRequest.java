package com.example.pejon.model.dto.auth;

public record RegisterRequest(
        String name,
        String login,
        String password,
        Long roleId
) {
}
