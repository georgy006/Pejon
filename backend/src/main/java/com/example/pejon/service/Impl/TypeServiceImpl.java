package com.example.pejon.service.Impl;

import com.example.pejon.model.Type;
import com.example.pejon.repository.TypeRepository;
import com.example.pejon.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeRepository typeRepository;

    @Override
    public List<Type> getAllType() {
        return typeRepository.findAll();
    }

    @Override
    public Type getTypeById(Long id) {
        return typeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Тип не найден: " + id));
    }

    @Override
    public Type addType(Type type) {
        typeRepository.save(type);
        return type;
    }

    @Override
    public Type updateTypeById(Long id, Type type) {
        Type t = typeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Type не найден: " + id));

        t.setName(type.getName());
        t.setTerminal(type.getTerminal());

        typeRepository.save(t);
        return t;
    }

    @Override
    public void deleteTypeById(Long id) {
        Type type = typeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Type не найден: " + id));
        typeRepository.delete(type);
    }
}
