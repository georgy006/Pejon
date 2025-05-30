package com.example.pejon.controller;

import com.example.pejon.model.dto.line_dto.LineCreateDto;
import com.example.pejon.model.dto.line_dto.LineDto;
import com.example.pejon.model.dto.line_dto.LineWithCellDto;
import com.example.pejon.model.dto.line_dto.LineWithShelvesDto;
import com.example.pejon.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public LineDto addLine(@RequestBody LineCreateDto lineCreateDto){
        return lineService.addLine(lineCreateDto);
    }
    @PostMapping("/{id}")
    public LineDto updateLineById(@PathVariable Long id, @RequestBody LineCreateDto lineCreateDto){
        return lineService.updateLineById(id, lineCreateDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLineById(@PathVariable Long id){
        lineService.deleteLineById(id);
        return ResponseEntity.ok("Линия удалена");
    }
}
