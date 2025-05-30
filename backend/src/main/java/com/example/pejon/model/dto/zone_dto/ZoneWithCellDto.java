package com.example.pejon.model.dto.zone_dto;

import com.example.pejon.model.dto.cell_dto.CellDto;

import java.util.List;

public record ZoneWithCellDto(
        Long id,
        String name,
        List<CellDto> cellDto

) {
}
