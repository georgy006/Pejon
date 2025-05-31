package com.example.pejon.model.dto.zone_dto;


public record ZoneCreateDto(
        Long id,
        String name,
        int capacity,
        Long warehouseId
){
}
