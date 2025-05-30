package com.example.pejon.service.convertor;

import com.example.pejon.model.Line;
import com.example.pejon.model.dto.LineDto;
import org.springframework.stereotype.Component;

@Component
public class LineConvertor {
    public LineDto convertToLineDto(Line line){
        return new LineDto(
                line.getId(),
                line.getName(),
                line.getCountShelf()
        );
    }
}