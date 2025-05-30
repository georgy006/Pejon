package com.example.pejon.model.dto.container_dto;

import com.example.pejon.model.dto.cell_dto.CellDto;

import java.util.List;

public record ContainerWithCellDto(
        Long id,
        String name,
        List<CellDto> cellDto
) {
}
