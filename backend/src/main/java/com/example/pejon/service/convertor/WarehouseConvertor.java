package com.example.pejon.service.convertor;

import com.example.pejon.model.Line;
import com.example.pejon.model.Warehouse;
import com.example.pejon.model.Zone;
import com.example.pejon.model.dto.WarehouseDto;
import com.example.pejon.repository.LinesRepository;
import com.example.pejon.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class WarehouseConvertor {
    @Autowired
    ZoneConvertor zoneConvertor;
    @Autowired
    LineConvertor lineConvertor;

    @Autowired
    ZoneRepository zoneRepository;
    @Autowired
    LinesRepository linesRepository;
    public WarehouseDto convertToWarehouseDto(Warehouse warehouse){
        List<Zone> zones = zoneRepository.findAllByWarehouseId(warehouse.getId());
        List<Line> lines = linesRepository.findAllByWarehouseId(warehouse.getId());
        return new WarehouseDto(
                warehouse.getId(),
                warehouse.getName(),
                zones.stream()
                        .map(zoneConvertor::convertToZoneDto)
                        .collect(Collectors.toList()),
                lines.stream()
                        .map(lineConvertor::convertToLineDto)
                        .collect(Collectors.toList())
        );
    }
}
