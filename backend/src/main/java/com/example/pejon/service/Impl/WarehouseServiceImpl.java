package com.example.pejon.service.Impl;

import com.example.pejon.model.Line;
import com.example.pejon.model.Warehouse;
import com.example.pejon.model.Zone;
import com.example.pejon.model.dto.line_dto.LineDto;
import com.example.pejon.model.dto.WarehouseDto;
import com.example.pejon.model.dto.zone_dto.ZoneDto;
import com.example.pejon.repository.LinesRepository;
import com.example.pejon.repository.WarehouseRepository;
import com.example.pejon.repository.ZoneRepository;
import com.example.pejon.service.WarehouseService;
import com.example.pejon.service.convertor.LineConvertor;
import com.example.pejon.service.convertor.WarehouseConvertor;
import com.example.pejon.service.convertor.ZoneConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    WarehouseConvertor warehouseConvertor;
    @Autowired
    LineConvertor lineConvertor;
    @Autowired
    ZoneRepository zoneRepository;


    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    LinesRepository linesRepository;
    @Autowired
    ZoneConvertor zoneConvertor;

    @Override
    public List<Warehouse> getAllWarehouse() {
        List<Warehouse> warehouses = warehouseRepository.findAll();

        return warehouses;
    }

    @Override
    public WarehouseDto getWarehouseById(Long id) {
        Optional<Warehouse> warehouse = warehouseRepository.findById(id);
        return warehouseConvertor.convertToWarehouseDto(warehouse.get());
    }

    @Override
    public List<LineDto> getLinesByWarehouseId(Long id) {
        List<Line> lines = linesRepository.findAllByWarehouseId(id);
        return lines.stream()
                .map(lineConvertor::convertToLineDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ZoneDto> getZoneByWarehouseId(Long id) {
        List<Zone> zones = zoneRepository.findAllByWarehouseId(id);
        return zones.stream()
                .map(zoneConvertor::convertToZoneDto)
                .collect(Collectors.toList());
    }

    @Override
    public WarehouseDto addWarehouse(Warehouse warehouse) {
        warehouseRepository.save(warehouse);
        return warehouseConvertor.convertToWarehouseDto(warehouse);
    }

    @Override
    public WarehouseDto updateWarehouse(Long id, Warehouse warehouse) {
        Warehouse wh = warehouseRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Склад не найден: " + id));
        wh.setName(warehouse.getName());
        warehouseRepository.save(wh);
        return warehouseConvertor.convertToWarehouseDto(wh);
    }

    @Override
    public void deleteWarehouseById(Long id) {
        Warehouse wh = warehouseRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Склад не найден: " + id));
        warehouseRepository.delete(wh);
    }
}
