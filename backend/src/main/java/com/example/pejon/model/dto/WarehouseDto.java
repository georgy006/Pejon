package com.example.pejon.model.dto;


import java.util.List;

public record WarehouseDto (
        Long id,
        String name,
        int countLine,
        List<ZoneDto> zone,
        List<LineDto> line
){
}
