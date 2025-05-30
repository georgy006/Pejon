package com.example.pejon.controller;

import com.example.pejon.model.Status;
import com.example.pejon.model.Type;
import com.example.pejon.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {
    @Autowired
    StatusService statusService;

    @GetMapping("/all")
    public List<Status> getAllStatus() {
        return statusService.getAllStatus();
    }
    @GetMapping("/{id}")
    public Status getStatusById(@PathVariable Long id) {
        return statusService.getStatusById(id);
    }
    @PostMapping("/")
    public Status addStatus(@RequestBody Status status) {
        return statusService.addStatus(status);
    }
    @PostMapping("/{id}")
    public Status updateStatusById(@PathVariable Long id, @RequestBody Status status) {
        return statusService.updateStatusById(id, status);
    }
}
