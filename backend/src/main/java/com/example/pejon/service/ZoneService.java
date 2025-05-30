package com.example.pejon.service;

import com.example.pejon.model.dto.zone_dto.ZoneDto;
import com.example.pejon.model.dto.zone_dto.ZoneWithCellDto;

import java.util.List;

public interface ZoneService {
    List<ZoneDto> getAllZones();
    ZoneDto getZoneById(Long id);
    ZoneWithCellDto getAllCellsByZoneId(Long id);
    List<ZoneWithCellDto> getAllCellsByAllZones();
}
