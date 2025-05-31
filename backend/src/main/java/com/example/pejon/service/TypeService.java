package com.example.pejon.service;

import com.example.pejon.model.Type;

import java.util.List;

public interface TypeService {
    List<Type> getAllType();
    Type getTypeById(Long id);
    Type addType(Type type);
    Type updateTypeById(Long id, Type type);
    void deleteTypeById(Long id);
}
