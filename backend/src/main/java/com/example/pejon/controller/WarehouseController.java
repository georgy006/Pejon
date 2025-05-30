package com.example.pejon.controller;

import com.example.pejon.model.Status;
import com.example.pejon.model.Warehouse;
import com.example.pejon.model.dto.line_dto.LineDto;
import com.example.pejon.model.dto.WarehouseDto;
import com.example.pejon.model.dto.zone_dto.ZoneDto;
import com.example.pejon.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    @Autowired
    WarehouseService warehouseService;

    @GetMapping("/all")
    public List<Warehouse> getAllWarehouse() {
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
    @PostMapping("/{id}")
    public WarehouseDto updateWarehouseById(@PathVariable Long id, @RequestBody Warehouse warehouse) {
        return warehouseService.updateWarehouse(id, warehouse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWarehouseById(@PathVariable Long id) {
        warehouseService.deleteWarehouseById(id);
        return ResponseEntity.ok("Склад удален");
    }
}
