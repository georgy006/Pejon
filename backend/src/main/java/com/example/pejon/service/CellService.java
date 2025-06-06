package com.example.pejon.service;

import com.example.pejon.model.dto.cell_dto.CellCreateDto;
import com.example.pejon.model.dto.cell_dto.CellDto;

import java.util.List;

public interface CellService {
    List<CellDto> getAllCell();
    CellDto getCellById(Long id);
    CellDto addCellByStorageId(Long storageId, CellCreateDto cellCreateDto);
    CellDto addCell(CellCreateDto cellCreateDto);
    CellDto updateCellById(Long id, CellCreateDto cellCreateDto);
    CellDto clearCellById(Long id);
    void deleteCellById(Long id);

    List<CellDto> searchByTransportContainerName(String name);

}
