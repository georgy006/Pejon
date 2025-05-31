package com.example.pejon.model.dto.shelf_dto;

public record ShelfCreateDto(
        Long id,
        String name,
        int capacity,
        Long lineId
) {
}
