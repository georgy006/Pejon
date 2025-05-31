package com.example.pejon.model.dto.application_dto;


public record ApplicationCreateDto(
        Long id,
        String title,
        String description,
        String data,

        Long typeId,
        Long cellId,
        Long statusId,
        Long authorId


) {
}
