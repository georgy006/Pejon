package com.example.pejon.service.Impl;

import com.example.pejon.model.Zone;
import com.example.pejon.model.dto.zone_dto.ZoneDto;
import com.example.pejon.model.dto.zone_dto.ZoneWithCellDto;
import com.example.pejon.repository.ZoneRepository;
import com.example.pejon.service.ZoneService;
import com.example.pejon.service.convertor.ZoneConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ZoneServiceImpl implements ZoneService {

    @Autowired
    ZoneRepository zoneRepository;

    @Autowired
    ZoneConvertor zoneConvertor;

    @Override
    public List<ZoneDto> getAllZones() {
        List<Zone> zones = zoneRepository.findAll();
        return zones.stream()
                .map(zoneConvertor:: convertToZoneDto)
                .collect(Collectors.toList());
    }

    @Override
    public ZoneDto getZoneById(Long id) {
        Optional<Zone> zone = zoneRepository.findById(id);
        return zoneConvertor.convertToZoneDto(zone.get());
    }

    @Override
    public ZoneWithCellDto getAllCellsByZoneId(Long id) {
        Optional<Zone> zone = zoneRepository.findById(id);
        return zoneConvertor.convertToZoneWithCellDto(zone.get());
    }

    @Override
    public List<ZoneWithCellDto> getAllCellsByAllZones() {
        List<Zone> zone = zoneRepository.findAll();
        return zone.stream()
                .map(zoneConvertor::convertToZoneWithCellDto)
                .collect(Collectors.toList());
    }
}
