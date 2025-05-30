package com.example.pejon.service;

import com.example.pejon.model.dto.shelf_dto.ShelfDto;
import com.example.pejon.model.dto.shelf_dto.ShelfWithCellDto;

import java.util.List;

public interface ShelfService {
    List<ShelfDto> getAllShelves();
    ShelfDto getShelfById(Long id);
    ShelfWithCellDto getAllCellsByShelfId(Long id);
    List<ShelfWithCellDto> getAllCellsByAllShelves();
    List<ShelfWithCellDto> getShelvesByLineId(Long id);
}
