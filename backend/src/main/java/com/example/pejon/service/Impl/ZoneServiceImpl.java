package com.example.pejon.service.Impl;

import com.example.pejon.model.Warehouse;
import com.example.pejon.model.Zone;
import com.example.pejon.model.dto.zone_dto.ZoneCreateDto;
import com.example.pejon.model.dto.zone_dto.ZoneDto;
import com.example.pejon.model.dto.zone_dto.ZoneWithCellDto;
import com.example.pejon.repository.WarehouseRepository;
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
    WarehouseRepository warehouseRepository;

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

    @Override
    public ZoneDto addZone(ZoneCreateDto zoneCreateDto) {
        Warehouse warehouse = warehouseRepository.findById(zoneCreateDto.warehouseId())
                .orElseThrow(()-> new RuntimeException("Warehouse Не найдено"));
        Zone zone = new Zone();

        zone.setName(zoneCreateDto.name());
        zone.setCapacity(zoneCreateDto.capacity());
        zone.setWarehouse(warehouse);

        zoneRepository.save(zone);

        return zoneConvertor.convertToZoneDto(zone);
    }

    @Override
    public ZoneDto updateZoneById(Long id, ZoneCreateDto zoneCreateDto) {
        Warehouse warehouse = warehouseRepository.findById(zoneCreateDto.warehouseId())
                .orElseThrow(()-> new RuntimeException("Warehouse Не найдено"));
        Zone zone = zoneRepository.findById(id)
                        .orElseThrow(()-> new RuntimeException("Zone Не найдено"));

        zone.setName(zoneCreateDto.name());
        zone.setCapacity(zoneCreateDto.capacity());
        zone.setWarehouse(warehouse);

        zoneRepository.save(zone);

        return zoneConvertor.convertToZoneDto(zone);
    }

    @Override
    public void deleteZoneById(Long id) {
        Zone zone = zoneRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Zone Не найдено"));

        zoneRepository.delete(zone);
    }
}
