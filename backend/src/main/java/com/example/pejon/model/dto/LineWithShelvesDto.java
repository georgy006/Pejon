package com.example.pejon.model.dto;

import java.util.List;

public record LineWithShelvesDto(
    Long id,
    String name,
    int count,
    List<ShelfWithCellDto> shelfDtos
){
}
