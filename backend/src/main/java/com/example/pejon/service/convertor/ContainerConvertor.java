package com.example.pejon.service.convertor;

import com.example.pejon.model.Cell;
import com.example.pejon.model.Container;
import com.example.pejon.model.dto.ContainerDto;
import com.example.pejon.model.dto.ContainerWithCellDto;
import com.example.pejon.repository.CellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContainerConvertor {
    @Autowired
    CellRepository cellRepository;


    @Autowired
    CellConvertor cellConvertor;

    public ContainerDto convertToContainerDto(Container container){
        return new ContainerDto(
                container.getId(),
                container.getName()
        );
    }
    public ContainerWithCellDto convertToContainerWithCellDto(Container container){
        List<Cell> cells = cellRepository.findAllByStorage_Id(container.getId());

        return new ContainerWithCellDto(
                container.getId(),
                container.getName(),
                cells.stream()
                        .map(cellConvertor::convertToCellDto)
                        .collect(Collectors.toList())
        );
    }
}
