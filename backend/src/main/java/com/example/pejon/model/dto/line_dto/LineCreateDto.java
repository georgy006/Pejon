package com.example.pejon.model.dto.line_dto;

public record LineCreateDto(
        Long id,
        String name,
        Long warehouseId
) {
}
