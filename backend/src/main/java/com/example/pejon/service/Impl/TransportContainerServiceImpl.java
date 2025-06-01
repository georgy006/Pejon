package com.example.pejon.service.Impl;

import com.example.pejon.model.TransportContainer;
import com.example.pejon.repository.TransportContainerRepository;
import com.example.pejon.service.TransportContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportContainerServiceImpl implements TransportContainerService {

    @Autowired
    TransportContainerRepository transportContainerRepository;

    @Override
    public List<TransportContainer> getAllTransportContainer() {
        return transportContainerRepository.findAll();
    }

    @Override
    public TransportContainer getTransportContainerById(Long id) {
        return transportContainerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Не найден"));
    }

    @Override
    public TransportContainer addTransportContainer(TransportContainer transportContainer) {
        TransportContainer tc = new TransportContainer();
        tc.setName(transportContainer.getName());
        return transportContainerRepository.save(tc);
    }

    @Override
    public TransportContainer updateTransportContainerById(Long id, TransportContainer transportContainer) {
        TransportContainer tc = transportContainerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Не найден"));

        tc.setName(transportContainer.getName());

        return transportContainerRepository.save(tc);
    }

    @Override
    public void deleteTransportContainerById(Long id) {
        TransportContainer tc = transportContainerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Не найден"));
        transportContainerRepository.delete(tc);
    }
}
