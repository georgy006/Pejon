package com.example.pejon.service.convertor;

import com.example.pejon.model.Cell;
import com.example.pejon.model.Line;
import com.example.pejon.model.Shelf;
import com.example.pejon.model.dto.LineDto;
import com.example.pejon.model.dto.LineWithCellDto;
import com.example.pejon.model.dto.LineWithShelvesDto;
import com.example.pejon.repository.CellRepository;
import com.example.pejon.repository.ShelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LineConvertor {
    @Autowired
    CellRepository cellRepository;
    @Autowired
    ShelfRepository shelfRepository;


    @Autowired
    CellConvertor cellConvertor;
    @Autowired
    ShelfConvertor shelfConvertor;

    public LineDto convertToLineDto(Line line){
        return new LineDto(
                line.getId(),
                line.getName(),
                line.getCountShelf()
        );
    }
    public LineWithCellDto convertToLineWithCellDto(Line line){
        return null;
    }
    public LineWithShelvesDto convertToLineWithShelvesDto(Line line){
        List<Shelf> shelves = shelfRepository.findByLineId(line.getId());
        return new LineWithShelvesDto(
                line.getId(),
                line.getName(),
                line.getCountShelf(),
                shelves.stream()
                        .map(shelfConvertor::convertToShelfWithCellDto)
                        .collect(Collectors.toList())
        );
    }
}