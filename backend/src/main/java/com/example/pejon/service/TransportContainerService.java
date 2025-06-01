package com.example.pejon.service;

import com.example.pejon.model.TransportContainer;

import java.util.List;

public interface TransportContainerService {
    List<TransportContainer> getAllTransportContainer();
    TransportContainer getTransportContainerById(Long id);
    TransportContainer addTransportContainer(TransportContainer transportContainer);
    TransportContainer updateTransportContainerById(Long id, TransportContainer transportContainer);
    void deleteTransportContainerById(Long id);
}
