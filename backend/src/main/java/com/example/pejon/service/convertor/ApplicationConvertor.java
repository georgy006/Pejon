package com.example.pejon.service.convertor;


import com.example.pejon.model.Application;
import com.example.pejon.model.dto.application_dto.ApplicationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConvertor {
    @Autowired
    CellConvertor cellConvertor;

    public ApplicationDto convertToApplicationDto(Application application){
        return new ApplicationDto(
                application.getId(),
                application.getTitle(),
                application.getDescription(),
                application.getData(),

                application.getType().getName(),
                cellConvertor.convertToCellDto(application.getCell()),

                application.getStatus().getName(),
                application.getAuthor() != null ? application.getAuthor().getName() : null,
                application.getApprover() != null ? application.getApprover().getName() : null
        );
    }
}
