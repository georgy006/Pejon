package com.example.pejon.model.dto.shelf_dto;

import com.example.pejon.model.dto.cell_dto.CellDto;

import java.util.List;

public record ShelfWithCellDto(
        Long id,
        String name,
        List<CellDto> cellDto
) {
}
