package com.example.pejon.model.dto.line_dto;

import com.example.pejon.model.dto.CellDto;

import java.util.List;

public record LineWithCellDto (
        Long id,
        String name,
        int count,
        List<CellDto> cellDto
){
}
