package com.example.pejon.service.convertor;

import com.example.pejon.model.Cell;
import com.example.pejon.model.Line;
import com.example.pejon.model.dto.LineDto;
import com.example.pejon.model.dto.LineWithCellDto;
import com.example.pejon.repository.CellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LineConvertor {
    @Autowired
    CellRepository cellRepository;


    @Autowired
    CellConvertor cellConvertor;
    public LineDto convertToLineDto(Line line){
        return new LineDto(
                line.getId(),
                line.getName(),
                line.getCountShelf()
        );
    }
    public LineWithCellDto convertToLineWithCellDto(Line line){
        List<Cell> cells = cellRepository.findAllByStorage_Id(line.getId());
        return new LineWithCellDto(
                line.getId(),
                line.getName(),
                line.getCountShelf(),
                cells.stream()
                        .map(cellConvertor::convertToCellDto)
                        .collect(Collectors.toList())
        );
    }
}