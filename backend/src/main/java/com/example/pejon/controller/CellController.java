package com.example.pejon.controller;

import com.example.pejon.model.dto.cell_dto.CellCreateDto;
import com.example.pejon.model.dto.cell_dto.CellDto;
import com.example.pejon.service.CellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cell")
public class CellController {
    @Autowired
    CellService cellService;

    @GetMapping("/all")
    public List<CellDto> getAllCell() {
        return cellService.getAllCell();
    }
    @GetMapping("/{id}")
    public CellDto getCellById(@PathVariable Long id){
        return cellService.getCellById(id);
    }
    @PostMapping
    public CellDto addCell(@RequestBody CellCreateDto cellCreateDto){
        return cellService.addCell(cellCreateDto);
    }
    @PostMapping("/{id}")
    public CellDto updateCellById(@PathVariable Long id, @RequestBody CellCreateDto cellCreateDto){
        return cellService.updateCellById(id,cellCreateDto);
    }
    @PostMapping("/{id}/clear")
    public CellDto clearCellById(@PathVariable Long id){
        return cellService.clearCellById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteCellById(@PathVariable Long id){
        cellService.deleteCellById(id);
    }

}
