package com.example.pejon.model.dto;


import com.example.pejon.model.dto.line_dto.LineDto;
import com.example.pejon.model.dto.zone_dto.ZoneDto;

import java.util.List;

public record WarehouseDto (
        Long id,
        String name,
        int countLine,
        List<ZoneDto> zone,
        List<LineDto> line
){
}
