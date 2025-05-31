package com.example.pejon.service.Impl;

import com.example.pejon.model.*;
import com.example.pejon.model.dto.application_dto.ApplicationCreateDto;
import com.example.pejon.model.dto.application_dto.ApplicationDto;
import com.example.pejon.repository.*;
import com.example.pejon.service.ApplicationService;
import com.example.pejon.service.convertor.ApplicationConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    ApplicationRepository applicationRepository;
    @Autowired
    TypeRepository typeRepository;
    @Autowired
    CellRepository cellRepository;
    @Autowired
    StatusRepository statusRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    ApplicationConvertor applicationConvertor;

    @Override
    public List<ApplicationDto> getAllApplication() {
        List<Application> applications = applicationRepository.findAll();
        return applications.stream()
                .map(applicationConvertor::convertToApplicationDto)
                .collect(Collectors.toList());
    }

    @Override
    public ApplicationDto getApplicationById(Long id) {
        Application application = applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application не найдено"));
        return applicationConvertor.convertToApplicationDto(application);
    }

    @Override
    public ApplicationDto addApplication(ApplicationCreateDto applicationCreateDto) {
        Type type = typeRepository.findById(applicationCreateDto.typeId())
                .orElseThrow(()-> new RuntimeException("Не найден"));
        Cell cell = cellRepository.findById(applicationCreateDto.cellId())
                .orElseThrow(()-> new RuntimeException("Не найден"));
        Status status = statusRepository.findById(applicationCreateDto.statusId())
                .orElseThrow(()-> new RuntimeException("Не найден"));
        User author = userRepository.findById(applicationCreateDto.authorId())
                .orElseThrow(()-> new RuntimeException("Не найден"));


        Application application = new Application();

        application.setTitle(applicationCreateDto.title());
        application.setDescription(applicationCreateDto.description());
        application.setData(applicationCreateDto.data());

        application.setType(type);
        application.setCell(cell);
        application.setStatus(status);
        application.setAuthor(author);
        application.setApprover(null);
        applicationRepository.save(application);
        return applicationConvertor.convertToApplicationDto(application);
    }

    @Override
    public ApplicationDto updateApplicationById(Long id, ApplicationCreateDto applicationCreateDto) {
        Type type = typeRepository.findById(applicationCreateDto.typeId())
                .orElseThrow(()-> new RuntimeException("Не найден"));
        Cell cell = cellRepository.findById(applicationCreateDto.cellId())
                .orElseThrow(()-> new RuntimeException("Не найден"));
        Status status = statusRepository.findById(applicationCreateDto.statusId())
                .orElseThrow(()-> new RuntimeException("Не найден"));
        User author = userRepository.findById(applicationCreateDto.authorId())
                .orElseThrow(()-> new RuntimeException("Не найден"));

        Application application = applicationRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Не найден"));

        application.setTitle(applicationCreateDto.title());
        application.setDescription(applicationCreateDto.description());
        application.setData(applicationCreateDto.data());

        application.setType(type);
        application.setCell(cell);
        application.setStatus(status);
        application.setAuthor(author);
        application.setApprover(null);
        applicationRepository.save(application);
        return applicationConvertor.convertToApplicationDto(application);
    }

    @Override
    public ApplicationDto approvedApplicationByApproverId(Long applicationId, Long approverId) {
        Application application = applicationRepository.findById(applicationId)
                .orElseThrow(()-> new RuntimeException("Не найден"));

        User approver = userRepository.findById(approverId)
                .orElseThrow(()-> new RuntimeException("Не найден"));


        application.setApprover(approver);
        applicationRepository.save(application);

        return applicationConvertor.convertToApplicationDto(application);
    }

}
