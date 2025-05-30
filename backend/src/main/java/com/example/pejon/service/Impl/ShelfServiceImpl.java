package com.example.pejon.service.Impl;

import com.example.pejon.model.Shelf;
import com.example.pejon.model.dto.ShelfDto;
import com.example.pejon.model.dto.ShelfWithCellDto;
import com.example.pejon.repository.ShelfRepository;
import com.example.pejon.service.ShelfService;
import com.example.pejon.service.convertor.ShelfConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShelfServiceImpl implements ShelfService {
    @Autowired
    ShelfRepository shelfRepository;

    @Autowired
    ShelfConvertor shelfConvertor;

    @Override
    public List<ShelfDto> getAllShelves() {
        List<Shelf> shelves = shelfRepository.findAll();
        return shelves.stream()
                .map(shelfConvertor::convertToShelfDto)
                .collect(Collectors.toList());
    }

    @Override
    public ShelfDto getShelfById(Long id) {
        Optional<Shelf> shelf = shelfRepository.findById(id);
        return shelfConvertor.convertToShelfDto(shelf.get());
    }

    @Override
    public ShelfWithCellDto getAllCellsByShelfId(Long id) {
        Optional<Shelf> shelf = shelfRepository.findById(id);
        return shelfConvertor.convertToShelfWithCellDto(shelf.get());
    }

    @Override
    public List<ShelfWithCellDto> getAllCellsByAllShelves() {
        List<Shelf> shelves = shelfRepository.findAll();
        return shelves.stream()
                .map(shelfConvertor::convertToShelfWithCellDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ShelfWithCellDto> getShelvesByLineId(Long id) {
        List<Shelf> shelves = shelfRepository.findByLineId(id);
        return shelves.stream()
                .map(shelfConvertor::convertToShelfWithCellDto)
                .collect(Collectors.toList());
    }
}
