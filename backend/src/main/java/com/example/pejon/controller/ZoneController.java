package com.example.pejon.controller;

import com.example.pejon.model.dto.zone_dto.ZoneDto;
import com.example.pejon.model.dto.zone_dto.ZoneWithCellDto;
import com.example.pejon.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/zone")
public class ZoneController {
    @Autowired
    ZoneService zoneService;

    @GetMapping("/all")
    public List<ZoneDto> getAllZones() {
        return zoneService.getAllZones();
    }
    @GetMapping("/{id}")
    public ZoneDto getZoneById(@PathVariable Long id){
        return zoneService.getZoneById(id);
    }

    @GetMapping("/{id}/cells")
    public ZoneWithCellDto getAllCellsByZoneId(@PathVariable Long id){
        return zoneService.getAllCellsByZoneId(id);
    }
    @GetMapping("/cells")
    public List<ZoneWithCellDto>  getAllCellsByAllZones(){
        return zoneService.getAllCellsByAllZones();
    }
}
