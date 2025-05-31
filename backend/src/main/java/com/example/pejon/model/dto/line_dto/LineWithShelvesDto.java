package com.example.pejon.model.dto.line_dto;

import com.example.pejon.model.dto.shelf_dto.ShelfWithCellDto;

import java.util.List;

public record LineWithShelvesDto(
    Long id,
    String name,
    List<ShelfWithCellDto> shelfDtos
){
}
