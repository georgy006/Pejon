package com.example.pejon.service;

import com.example.pejon.model.dto.line_dto.LineCreateDto;
import com.example.pejon.model.dto.line_dto.LineDto;
import com.example.pejon.model.dto.line_dto.LineWithCellDto;
import com.example.pejon.model.dto.line_dto.LineWithShelvesDto;


import java.util.List;

public interface LineService {
    List<LineDto> getAllLine();
    LineWithShelvesDto getLineById(Long id);
    LineWithCellDto getAllCellsByLineId(Long id);
    List<LineWithCellDto> getAllCellsByAllLines();
    LineDto addLine(LineCreateDto lineCreateDto);
    LineDto updateLineById(Long id, LineCreateDto lineCreateDto);
    void deleteLineById(Long id);
}
