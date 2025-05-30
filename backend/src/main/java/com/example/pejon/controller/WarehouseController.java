package com.example.pejon.controller;

import com.example.pejon.model.Warehouse;
import com.example.pejon.model.dto.line_dto.LineDto;
import com.example.pejon.model.dto.WarehouseDto;
import com.example.pejon.model.dto.zone_dto.ZoneDto;
import com.example.pejon.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    @Autowired
    WarehouseService warehouseService;

    @GetMapping("/all")
    public List<WarehouseDto> getAllWarehouse() {
        return warehouseService.getAllWarehouse();
    }
    @GetMapping("/{id}")
    public WarehouseDto getWarehouseById(@PathVariable Long id){
        return warehouseService.getWarehouseById(id);
    }
    @GetMapping("/{id}/lines")
    public List<LineDto> getLinesByWarehouseId(@PathVariable Long id){
        return warehouseService.getLinesByWarehouseId(id);
    }
    @GetMapping("/{id}/zones")
    public List<ZoneDto> getFloorsByWarehouseId(@PathVariable Long id){
        return warehouseService.getZoneByWarehouseId(id);
    }
    @PostMapping
    public WarehouseDto addWarehouse(@RequestBody Warehouse warehouse){
        return warehouseService.addWarehouse(warehouse);
    }
}
