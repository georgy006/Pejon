package com.example.pejon.service.Impl;

import com.example.pejon.model.Cell;
import com.example.pejon.model.Storage;
import com.example.pejon.model.TransportContainer;
import com.example.pejon.model.dto.cell_dto.CellCreateDto;
import com.example.pejon.model.dto.cell_dto.CellDto;
import com.example.pejon.repository.CellRepository;
import com.example.pejon.repository.StorageRepository;
import com.example.pejon.repository.TransportContainerRepository;
import com.example.pejon.service.CellService;
import com.example.pejon.service.convertor.CellConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CellServiceImpl implements CellService {

    @Autowired
    CellRepository cellRepository;
    @Autowired
    TransportContainerRepository transportContainerRepository;
    @Autowired
    StorageRepository storageRepository;

    @Autowired
    CellConvertor cellConvertor;
    @Override
    public List<CellDto> getAllCell() {
        List<Cell> cells = cellRepository.findAll();
        return cells.stream()
                .map(cellConvertor::convertToCellDto)
                .collect(Collectors.toList());
    }

    @Override
    public CellDto getCellById(Long id) {
        Optional<Cell> cell = cellRepository.findById(id);
        return cellConvertor.convertToCellDto(cell.get());
    }

    @Override
    public CellDto addCellByStorageId(Long storageId, CellCreateDto cellCreateDto) {
        TransportContainer transportContainer = transportContainerRepository.findById(cellCreateDto.transportContainerId())
                .orElseThrow(() -> new RuntimeException("TransportContainer не найдено"));

        Storage storage = storageRepository.findById(storageId)
                .orElseThrow(() -> new RuntimeException("Storage не найдено"));

        Cell cell = new Cell();
        cell.setName(cellCreateDto.name());
        cell.setDescription(cellCreateDto.description());
        cell.setTransportContainer(transportContainer);
        cell.setStorage(storage);

        cellRepository.save(cell);
        return cellConvertor.convertToCellDto(cell);
    }

    @Override
    public CellDto addCell(CellCreateDto cellCreateDto) {
        TransportContainer transportContainer = transportContainerRepository.findById(cellCreateDto.transportContainerId())
                .orElseThrow(() -> new RuntimeException("TransportContainer не найдено"));
        Storage storage = storageRepository.findById(cellCreateDto.storageId())
                .orElseThrow(() -> new RuntimeException("Storage не найдено"));
        Cell cell = new Cell();
        cell.setName(cellCreateDto.name());
        cell.setDescription(cellCreateDto.description());
        cell.setTransportContainer(transportContainer);
        cell.setStorage(storage);

        cellRepository.save(cell);
        return cellConvertor.convertToCellDto(cell);
    }

    @Override
    public CellDto updateCellById(Long id, CellCreateDto cellCreateDto) {
        Storage storage = storageRepository.findById(cellCreateDto.storageId())
                .orElseThrow(() -> new RuntimeException("Storage не найдено"));

        Cell cell = cellRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cell не найдено: " + id));
        TransportContainer transportContainer = transportContainerRepository.findById(cellCreateDto.transportContainerId())
                        .orElseThrow(()-> new RuntimeException("TransportContainer не найдено"));

        cell.setName(cellCreateDto.name());
        cell.setDescription(cellCreateDto.description());
        cell.setTransportContainer(transportContainer);
        cell.setStorage(storage);

        cellRepository.save(cell);
        return cellConvertor.convertToCellDto(cell);
    }

    @Override
    public CellDto clearCellById(Long id) {
        Cell cell = cellRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cell не найдено: " + id));

        Storage storage = storageRepository.findById(cell.getStorage().getId())
                .orElseThrow(() -> new RuntimeException("Storage не найдено"));

        cell.setName("");
        cell.setDescription("");
        cell.setTransportContainer(null);
        cell.setStorage(storage);

        cellRepository.save(cell);
        return cellConvertor.convertToCellDto(cell);
    }

    @Override
    public void deleteCellById(Long id) {
        Cell cell = cellRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Не найдено"));
        cellRepository.delete(cell);
    }
}
