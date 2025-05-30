package com.example.pejon.model.dto.cell_dto;

public record CellCreateDto(
        Long id,
        String name,
        String description,
        Long transportContainerId,
        Long storageId
) {
}
