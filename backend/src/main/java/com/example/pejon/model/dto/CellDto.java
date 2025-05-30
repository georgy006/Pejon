package com.example.pejon.model.dto;

import com.example.pejon.model.Storage;
import com.example.pejon.model.TransportContainer;

public record CellDto(
        Long id,
        String name,
        String description,
        TransportContainer transportContainer,
        Storage storage
) {
}
