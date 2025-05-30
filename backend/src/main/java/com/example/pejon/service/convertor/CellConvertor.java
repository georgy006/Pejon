package com.example.pejon.service.convertor;

import com.example.pejon.model.Cell;
import com.example.pejon.model.Storage;
import com.example.pejon.model.TransportContainer;
import com.example.pejon.model.dto.CellDto;
import com.example.pejon.repository.StorageRepository;
import com.example.pejon.repository.TransportContainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
