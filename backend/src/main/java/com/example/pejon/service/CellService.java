package com.example.pejon.service;

import com.example.pejon.model.dto.cell_dto.CellDto;

public interface CellService {
    CellDto getAllCell();
    CellDto getCellById();
    CellDto addCellByStorageId();
}
