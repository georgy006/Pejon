package com.example.pejon.service.Impl;

import com.example.pejon.model.Line;
import com.example.pejon.model.dto.LineDto;
import com.example.pejon.model.dto.LineWithCellDto;
import com.example.pejon.repository.LinesRepository;
import com.example.pejon.service.LineService;
import com.example.pejon.service.convertor.LineConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LineServiceImpl implements LineService {
    @Autowired
    LinesRepository linesRepository;


    @Autowired
    LineConvertor lineConvertor;
    @Override
    public List<LineDto> getAllLine() {
        List<Line> lines = linesRepository.findAll();
        return lines.stream()
                .map(lineConvertor::convertToLineDto)
                .collect(Collectors.toList());
    }

    @Override
    public LineDto getLineById(Long id) {
        Optional<Line> line = linesRepository.findById(id);
        return lineConvertor.convertToLineDto(line.get());
    }

    @Override
    public LineWithCellDto getAllCellsByLineId(Long id) {
        Optional<Line> line = linesRepository.findById(id);
        return lineConvertor.convertToLineWithCellDto(line.get());
    }

    @Override
    public List<LineWithCellDto> getAllCellsByAllLines() {
        List<Line> lines = linesRepository.findAll();
        return lines.stream()
                .map(lineConvertor::convertToLineWithCellDto)
                .collect(Collectors.toList());
    }
}
