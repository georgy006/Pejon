package com.example.pejon.controller;

import com.example.pejon.model.dto.container_dto.ContainerDto;
import com.example.pejon.model.dto.container_dto.ContainerWithCellDto;
import com.example.pejon.service.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/container")
public class ContainerController {
    @Autowired
    ContainerService containerService;

    @GetMapping("/all")
    public List<ContainerDto> getAllContainers() {
        return containerService.getAllContainers();
    }
    @GetMapping("/{id}")
    public ContainerDto getContainerById(@PathVariable Long id){
        return containerService.getContainerById(id);
    }

    @GetMapping("/{id}/cells")
    public ContainerWithCellDto getCellsByContainerId(@PathVariable Long id){
        return containerService.getAllCellsByContainerId(id);
    }
    @GetMapping("/cells")
    public List<ContainerWithCellDto>  getCellsByAllContainers(){
        return containerService.getAllCellsByAllContainers();
    }
}
