package com.example.pejon.service.convertor;

import com.example.pejon.model.Cell;
import com.example.pejon.model.Zone;
import com.example.pejon.model.dto.zone_dto.ZoneDto;
import com.example.pejon.model.dto.zone_dto.ZoneWithCellDto;
import com.example.pejon.repository.CellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ZoneConvertor {
    @Autowired
    CellRepository cellRepository;

    @Autowired
    CellConvertor cellConvertor;
    public ZoneDto convertToZoneDto(Zone zone){
        return new ZoneDto(
                zone.getId(),
                zone.getName(),
                zone.getCapacity()
        );
    }
    public ZoneWithCellDto convertToZoneWithCellDto(Zone zone){
        List<Cell> cells = cellRepository.findAllByStorage_Id(zone.getId());
        return new ZoneWithCellDto(
                zone.getId(),
                zone.getName(),
                cells.stream()
                        .map(cellConvertor::convertToCellDto)
                        .collect(Collectors.toList())
        );
    }
}