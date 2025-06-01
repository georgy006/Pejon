package com.example.pejon.controller;

import com.example.pejon.model.Type;
import com.example.pejon.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeController {
    @Autowired
    TypeService typeService;

    @GetMapping("/all")
    public List<Type> getAllType() {
        return typeService.getAllType();
    }
    @GetMapping("/{id}")
    public Type getTypeById(@PathVariable Long id) {
        return typeService.getTypeById(id);
    }
    @PostMapping
    public Type addType(@RequestBody Type type) {
        return typeService.addType(type);
    }
    @PostMapping("/{id}")
    public Type updateTypeById(@PathVariable Long id, @RequestBody Type type) {
        return typeService.updateTypeById(id, type);
    }
    @DeleteMapping("/{id}")
    public void deleteTypeById(@PathVariable Long id){
        typeService.deleteTypeById(id);
    }
}
