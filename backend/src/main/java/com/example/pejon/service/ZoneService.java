package com.example.pejon.service;

import com.example.pejon.model.dto.zone_dto.ZoneCreateDto;
import com.example.pejon.model.dto.zone_dto.ZoneDto;
import com.example.pejon.model.dto.zone_dto.ZoneWithCellDto;

import java.util.List;

public interface ZoneService {
    List<ZoneDto> getAllZones();
    ZoneDto getZoneById(Long id);
    ZoneWithCellDto getAllCellsByZoneId(Long id);
    List<ZoneWithCellDto> getAllCellsByAllZones();

    ZoneDto addZone(ZoneCreateDto zoneCreateDto);
    ZoneDto updateZoneById(Long id, ZoneCreateDto zoneCreateDto);
    void deleteZoneById(Long id);
}
