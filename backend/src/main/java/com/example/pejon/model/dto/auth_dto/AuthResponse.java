package com.example.pejon.model.dto.auth_dto;

public record AuthResponse(
        String jwt,
        Long userId
) {
}
