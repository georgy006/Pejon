package com.example.pejon.model.dto;

import com.example.pejon.model.Warehouse;

import java.util.List;

public record ZoneWithCellDto(
        Long id,
        String name,
        List<CellDto> cellDto

) {
}
