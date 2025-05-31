package com.example.pejon.service.Impl;

import com.example.pejon.model.Cell;
import com.example.pejon.model.Line;
import com.example.pejon.model.Shelf;
import com.example.pejon.model.dto.shelf_dto.ShelfCreateDto;
import com.example.pejon.model.dto.shelf_dto.ShelfDto;
import com.example.pejon.model.dto.shelf_dto.ShelfWithCellDto;
import com.example.pejon.repository.CellRepository;
import com.example.pejon.repository.LinesRepository;
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
    LinesRepository linesRepository;

    @Autowired
    ShelfConvertor shelfConvertor;
    @Autowired
    CellRepository cellRepository;

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

    @Override
    public ShelfDto addShelf(ShelfCreateDto shelfCreateDto) {
        Line line = linesRepository.findById(shelfCreateDto.lineId())
                .orElseThrow(()-> new RuntimeException("Line Не найдено"));

        Shelf shelf = new Shelf();
        shelf.setName(shelfCreateDto.name());
        shelf.setCapacity(shelfCreateDto.capacity());
        shelf.setLine(line);
        shelfRepository.save(shelf);

        createCellByShelf(shelf,shelf.getCapacity());

        return shelfConvertor.convertToShelfDto(shelf);
    }
    private void createCellByShelf(Shelf shelf, int count){
        if(count > 50){ count = 50;}

        for (int i = 0; i < count; i++) {
            Cell cell = new Cell();
            cell.setName("");
            cell.setDescription("");
            cell.setTransportContainer(null);
            cell.setStorage(shelf);
            cellRepository.save(cell);
        }
    }


    @Override
    public ShelfDto updateShelfById(Long id, ShelfCreateDto shelfCreateDto) {
        Line line = linesRepository.findById(shelfCreateDto.lineId())
                .orElseThrow(()-> new RuntimeException("Line Не найдено"));

        Shelf shelf = shelfRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Shelf Не найдено"));

        shelf.setName(shelfCreateDto.name());
        shelf.setCapacity(shelfCreateDto.capacity());
        shelf.setLine(line);
        shelfRepository.save(shelf);
        return shelfConvertor.convertToShelfDto(shelf);
    }

    @Override
    public void deleteShelfById(Long id) {
        Shelf shelf = shelfRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Shelf Не найдено"));
        shelfRepository.delete(shelf);

    }
}
