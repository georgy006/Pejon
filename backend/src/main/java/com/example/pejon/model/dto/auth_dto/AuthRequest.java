package com.example.pejon.model.dto.auth_dto;

public record AuthRequest(
        String login,
        String password
) {
}
