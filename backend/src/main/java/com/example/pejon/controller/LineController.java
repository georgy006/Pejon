package com.example.pejon.controller;

import com.example.pejon.model.dto.line_dto.LineDto;
import com.example.pejon.model.dto.line_dto.LineWithCellDto;
import com.example.pejon.model.dto.line_dto.LineWithShelvesDto;
import com.example.pejon.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/line")
public class LineController {
    @Autowired
    LineService lineService;

    @GetMapping("/all")
    public List<LineDto> getAllLines() {
        return lineService.getAllLine();
    }
    @GetMapping("/{id}")
    public LineWithShelvesDto getLineById(@PathVariable Long id){
        return lineService.getLineById(id);
    }

    @GetMapping("/{id}/cells")
    public LineWithCellDto getAllCellsByLineId(@PathVariable Long id){
        return lineService.getAllCellsByLineId(id);
    }
    @GetMapping("/cells")
    public List<LineWithCellDto>  getAllCellsByAllLines(){
        return lineService.getAllCellsByAllLines();
    }

}
