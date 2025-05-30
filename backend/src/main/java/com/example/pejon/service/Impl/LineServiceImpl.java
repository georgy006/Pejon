package com.example.pejon.service.Impl;

import com.example.pejon.model.Line;
import com.example.pejon.model.Warehouse;
import com.example.pejon.model.dto.line_dto.LineCreateDto;
import com.example.pejon.model.dto.line_dto.LineDto;
import com.example.pejon.model.dto.line_dto.LineWithCellDto;
import com.example.pejon.model.dto.line_dto.LineWithShelvesDto;
import com.example.pejon.repository.LinesRepository;
import com.example.pejon.repository.WarehouseRepository;
import com.example.pejon.service.LineService;
import com.example.pejon.service.convertor.LineConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LineServiceImpl implements LineService {
    @Autowired
    LinesRepository linesRepository;
    @Autowired
    WarehouseRepository warehouseRepository;


    @Autowired
    LineConvertor lineConvertor;
    @Override
    public List<LineDto> getAllLine() {
        List<Line> lines = linesRepository.findAll();
        return lines.stream()
                .map(lineConvertor::convertToLineDto)
                .collect(Collectors.toList());
    }

    @Override
    public LineWithShelvesDto getLineById(Long id) {
        Optional<Line> line = linesRepository.findById(id);
        return lineConvertor.convertToLineWithShelvesDto(line.get());
    }

    @Override
    public LineWithCellDto getAllCellsByLineId(Long id) {
        Optional<Line> line = linesRepository.findById(id);
        return lineConvertor.convertToLineWithCellDto(line.get());
    }

    @Override
    public List<LineWithCellDto> getAllCellsByAllLines() {
        List<Line> lines = linesRepository.findAll();
        return lines.stream()
                .map(lineConvertor::convertToLineWithCellDto)
                .collect(Collectors.toList());
    }

    @Override
    public LineDto addLine(LineCreateDto lineCreateDto) {
        Warehouse warehouse = warehouseRepository.findById(lineCreateDto.warehouseId())
                .orElseThrow(()-> new RuntimeException("Warehouse не найден"));

        Line line = new Line();
        line.setName(lineCreateDto.name());
        line.setCountShelf(lineCreateDto.count());
        line.setWarehouse(warehouse);
        linesRepository.save(line);
        return lineConvertor.convertToLineDto(line);
    }

    @Override
    public LineDto updateLineById(Long id, LineCreateDto lineCreateDto) {
        Warehouse warehouse = warehouseRepository.findById(lineCreateDto.warehouseId())
                .orElseThrow(()-> new RuntimeException("Warehouse не найден"));

        Line line = linesRepository.findById(id)
                        .orElseThrow(()-> new RuntimeException("Line не найден"));
        line.setName(lineCreateDto.name());
        line.setCountShelf(lineCreateDto.count());
        line.setWarehouse(warehouse);
        linesRepository.save(line);
        return lineConvertor.convertToLineDto(line);
    }

    @Override
    public void deleteLineById(Long id) {
        Line line = linesRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Line не найден"));
        linesRepository.delete(line);
    }


}
