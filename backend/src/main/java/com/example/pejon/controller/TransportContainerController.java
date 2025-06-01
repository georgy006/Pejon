package com.example.pejon.controller;

import com.example.pejon.model.TransportContainer;
import com.example.pejon.model.Type;
import com.example.pejon.service.TransportContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transport-container")
public class TransportContainerController {
    @Autowired
    TransportContainerService transportContainerService;

    @GetMapping("/all")
    public List<TransportContainer> getAllTransportContainer() {
        return transportContainerService.getAllTransportContainer();
    }
    @GetMapping("/{id}")
    public TransportContainer getTransportContainerById(@PathVariable Long id) {
        return transportContainerService.getTransportContainerById(id);
    }
    @PostMapping
    public TransportContainer addTransportContainer(@RequestBody TransportContainer transportContainer) {
        return transportContainerService.addTransportContainer(transportContainer);
    }
    @PostMapping("/{id}")
    public TransportContainer updateTransportContainerById(@PathVariable Long id, @RequestBody TransportContainer transportContainer) {
        return transportContainerService.updateTransportContainerById(id, transportContainer);
    }
    @DeleteMapping("/{id}")
    public void deleteTransportContainerById(@PathVariable Long id){
        transportContainerService.deleteTransportContainerById(id);
    }
}
