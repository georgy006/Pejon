package com.example.pejon.service.Impl;

import com.example.pejon.model.Cell;
import com.example.pejon.model.Container;
import com.example.pejon.model.dto.CellDto;
import com.example.pejon.model.dto.ContainerDto;
import com.example.pejon.model.dto.ContainerWithCellDto;
import com.example.pejon.repository.CellRepository;
import com.example.pejon.repository.ContainerRepository;
import com.example.pejon.repository.StorageRepository;
import com.example.pejon.service.ContainerService;
import com.example.pejon.service.convertor.CellConvertor;
import com.example.pejon.service.convertor.ContainerConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContainerServiceImpl implements ContainerService {

    @Autowired
    ContainerRepository containerRepository;


    @Autowired
    ContainerConvertor containerConvertor;

    @Override
    public List<ContainerDto> getAllContainers() {
        List<Container>  containers = containerRepository.findAll();
        return containers.stream()
                .map(containerConvertor::convertToContainerDto)
                .collect(Collectors.toList());
    }

    @Override
    public ContainerDto getContainerById(Long id) {
        Optional<Container> container = containerRepository.findById(id);
        return containerConvertor.convertToContainerDto(container.get());
    }

    @Override
    public ContainerWithCellDto getAllCellsByContainerId(Long id) {
        Optional<Container> container = containerRepository.findById(id);
        return containerConvertor.convertToContainerWithCellDto(container.get());
    }
    @Override
    public List<ContainerWithCellDto> getAllCellsByAllContainers() {
        List<Container>  containers = containerRepository.findAll();
        return containers.stream()
                .map(containerConvertor::convertToContainerWithCellDto)
                .collect(Collectors.toList());
    }
}
