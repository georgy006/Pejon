package com.example.pejon.service;

import com.example.pejon.model.dto.container_dto.ContainerDto;
import com.example.pejon.model.dto.container_dto.ContainerWithCellDto;

import java.util.List;

public interface ContainerService {
    List<ContainerDto> getAllContainers();
    ContainerDto getContainerById(Long id);
    ContainerWithCellDto getAllCellsByContainerId(Long id);
    List<ContainerWithCellDto> getAllCellsByAllContainers();
}
