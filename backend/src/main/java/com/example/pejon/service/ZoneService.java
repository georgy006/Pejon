package com.example.pejon.service;

import com.example.pejon.model.dto.ContainerDto;
import com.example.pejon.model.dto.ContainerWithCellDto;
import com.example.pejon.model.dto.ZoneDto;
import com.example.pejon.model.dto.ZoneWithCellDto;

import java.util.List;

public interface ZoneService {
    List<ZoneDto> getAllZones();
    ZoneDto getZoneById(Long id);
    ZoneWithCellDto getAllCellsByZoneId(Long id);
    List<ZoneWithCellDto> getAllCellsByAllZones();
}
