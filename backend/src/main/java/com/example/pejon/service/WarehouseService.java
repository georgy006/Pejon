package com.example.pejon.service;

import com.example.pejon.model.Warehouse;
import com.example.pejon.model.dto.LineDto;
import com.example.pejon.model.dto.WarehouseDto;
import com.example.pejon.model.dto.ZoneDto;

import java.util.List;


public interface WarehouseService {

    List<WarehouseDto> getAllWarehouse();
    WarehouseDto getWarehouseById(Long id);
    List<LineDto> getLinesByWarehouseId(Long id);
    List<ZoneDto> getZoneByWarehouseId(Long id);
    WarehouseDto createWarehouse(Warehouse warehouse);

}
