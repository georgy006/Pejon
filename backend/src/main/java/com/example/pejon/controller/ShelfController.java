package com.example.pejon.controller;

import com.example.pejon.model.dto.container_dto.ContainerCreateDto;
import com.example.pejon.model.dto.container_dto.ContainerDto;
import com.example.pejon.model.dto.shelf_dto.ShelfCreateDto;
import com.example.pejon.model.dto.shelf_dto.ShelfDto;
import com.example.pejon.model.dto.shelf_dto.ShelfWithCellDto;
import com.example.pejon.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/line/{id}")
    public List<ShelfWithCellDto>  getShelvesByLineId(@PathVariable Long id){
        return shelfService.getShelvesByLineId(id);
    }


    @PostMapping
    public ShelfDto addShelf(@RequestBody ShelfCreateDto shelf){
        return shelfService.addShelf(shelf);
    }
    @PostMapping("/{id}")
    public ShelfDto updateShelfById(@PathVariable Long id,@RequestBody ShelfCreateDto shelf){
        return shelfService.updateShelfById(id, shelf);
    }
    @DeleteMapping("/{id}")
    void deleteShelfById(@PathVariable Long id){
        shelfService.deleteShelfById(id);
    }
}
