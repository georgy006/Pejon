package com.example.pejon.service;

import com.example.pejon.model.dto.LineDto;
import com.example.pejon.model.dto.LineWithCellDto;


import java.util.List;

public interface LineService {
    List<LineDto> getAllLine();
    LineDto getLineById(Long id);
    LineWithCellDto getAllCellsByLineId(Long id);
    List<LineWithCellDto> getAllCellsByAllLines();
}
