package com.example.pejon.model.dto;

import java.util.List;

public record LineWithCellDto (
        Long id,
        String name,
        int count,
        List<CellDto> cellDto
){
}
