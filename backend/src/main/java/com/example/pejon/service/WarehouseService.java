package com.example.pejon.service;

import com.example.pejon.model.Warehouse;
import com.example.pejon.model.dto.line_dto.LineDto;
import com.example.pejon.model.dto.WarehouseDto;
import com.example.pejon.model.dto.zone_dto.ZoneDto;

import java.util.List;


public interface WarehouseService {

    List<WarehouseDto> getAllWarehouse();
    WarehouseDto getWarehouseById(Long id);
    List<LineDto> getLinesByWarehouseId(Long id);
    List<ZoneDto> getZoneByWarehouseId(Long id);
    WarehouseDto addWarehouse(Warehouse warehouse);
    WarehouseDto updateWarehouse(Long id, Warehouse warehouse);
    void deleteWarehouseById(Long id);

}
