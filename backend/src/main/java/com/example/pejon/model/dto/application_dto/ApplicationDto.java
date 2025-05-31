package com.example.pejon.model.dto.application_dto;

import com.example.pejon.model.User;
import com.example.pejon.model.dto.cell_dto.CellDto;

public record ApplicationDto(
    Long id,
    String title,
    String description,
    String data,

    String typeName,
    CellDto cellDto,
    String statusName,
    String authorName,
    String approverName
){
}
