package com.example.pejon.service;

import com.example.pejon.model.dto.application_dto.ApplicationCreateDto;
import com.example.pejon.model.dto.application_dto.ApplicationDto;

import java.util.List;

public interface ApplicationService {
    List<ApplicationDto> getAllApplication();
    ApplicationDto getApplicationById(Long id);

    ApplicationDto addApplication(ApplicationCreateDto applicationCreateDto);
    ApplicationDto updateApplicationById(Long id, ApplicationCreateDto applicationCreateDto);

    ApplicationDto approvedApplicationByApproverId(Long applicationId, Long approverId);
}
