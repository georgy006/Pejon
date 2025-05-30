package com.example.pejon.service.convertor;

import com.example.pejon.model.Cell;
import com.example.pejon.model.dto.cell_dto.CellDto;
import org.springframework.stereotype.Component;

@Component
public class CellConvertor {

    public CellDto convertToCellDto(Cell cell){
        return new CellDto(
                cell.getId(),
                cell.getName(),
                cell.getDescription(),
                cell.getTransportContainer(),
                cell.getStorage()
        );
    }
}
