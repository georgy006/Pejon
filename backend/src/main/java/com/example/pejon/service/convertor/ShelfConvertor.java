package com.example.pejon.service.convertor;

import com.example.pejon.model.Cell;
import com.example.pejon.model.Shelf;
import com.example.pejon.model.dto.shelf_dto.ShelfDto;
import com.example.pejon.model.dto.shelf_dto.ShelfWithCellDto;
import com.example.pejon.repository.CellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShelfConvertor {
    @Autowired
    CellRepository cellRepository;

    @Autowired
    CellConvertor cellConvertor;

    public ShelfDto convertToShelfDto(Shelf shelf){
        return new ShelfDto(
                shelf.getId(),
                shelf.getName(),
                shelf.getCapacity()
        );
    }
    public ShelfWithCellDto convertToShelfWithCellDto(Shelf shelf){
        List<Cell> cells = cellRepository.findAllByStorage_Id(shelf.getId());
        return new ShelfWithCellDto(
          shelf.getId(),
          shelf.getName(),
          shelf.getCapacity(),
          cells.stream()
                  .map(cellConvertor::convertToCellDto)
                  .collect(Collectors.toList())
        );
    }
}
