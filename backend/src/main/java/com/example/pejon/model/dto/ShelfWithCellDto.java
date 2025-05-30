package com.example.pejon.model.dto;

import java.util.List;

public record ShelfWithCellDto(
        Long id,
        String name,
        List<CellDto> cellDto
) {
}
