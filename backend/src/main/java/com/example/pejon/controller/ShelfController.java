package com.example.pejon.controller;

import com.example.pejon.model.dto.ShelfDto;
import com.example.pejon.model.dto.ShelfWithCellDto;
import com.example.pejon.model.dto.ZoneDto;
import com.example.pejon.model.dto.ZoneWithCellDto;
import com.example.pejon.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shelf")
public class ShelfController {
    @Autowired
    ShelfService shelfService;

    @GetMapping("/all")
    public List<ShelfDto> getAllShelves() {
        return shelfService.getAllShelves();
    }
    @GetMapping("/{id}")
    public ShelfDto getShelfById(@PathVariable Long id){
        return shelfService.getShelfById(id);
    }

    @GetMapping("/{id}/cells")
    public ShelfWithCellDto getAllCellsByShelfId(@PathVariable Long id){
        return shelfService.getAllCellsByShelfId(id);
    }
    @GetMapping("/cells")
    public List<ShelfWithCellDto>  getAllCellsByAllShelves(){
        return shelfService.getAllCellsByAllShelves();
    }
}
