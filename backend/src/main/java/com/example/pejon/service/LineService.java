package com.example.pejon.service;

import com.example.pejon.model.dto.LineDto;
import com.example.pejon.model.dto.LineWithCellDto;
import com.example.pejon.model.dto.LineWithShelvesDto;


import java.util.List;

public interface LineService {
    List<LineDto> getAllLine();
    LineWithShelvesDto getLineById(Long id);
    LineWithCellDto getAllCellsByLineId(Long id);
    List<LineWithCellDto> getAllCellsByAllLines();
}
