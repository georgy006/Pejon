package com.example.pejon.controller;

import com.example.pejon.model.dto.application_dto.ApplicationCreateDto;
import com.example.pejon.model.dto.application_dto.ApplicationDto;
import com.example.pejon.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/application")
public class ApplicationController {
    @Autowired
    ApplicationService applicationService;

    @GetMapping("/all")
    public List<ApplicationDto> getAllApplication() {
        return applicationService.getAllApplication();
    }
    @GetMapping("/{id}")
    public ApplicationDto getApplicationById(@PathVariable Long id){
        return applicationService.getApplicationById(id);
    }

    @PostMapping
    public ApplicationDto addApplication(@RequestBody ApplicationCreateDto applicationCreateDto){
        return applicationService.addApplication(applicationCreateDto);
    }
    @PostMapping("/{id}")
    public ApplicationDto updateApplicationById(@PathVariable Long id, @RequestBody ApplicationCreateDto applicationCreateDto){
        return applicationService.updateApplicationById(id, applicationCreateDto);
    }

    @PostMapping("/{applicationId}/approved/{approverId}")
    public ApplicationDto approvedApplicationByApproverId(@PathVariable Long applicationId, @PathVariable Long approverId){
        return applicationService.approvedApplicationByApproverId(applicationId, approverId);
    }

}
