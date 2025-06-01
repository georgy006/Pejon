package com.example.pejon.model.dto.auth;

public record AuthRequest(
        String login,
        String password
) {
}
