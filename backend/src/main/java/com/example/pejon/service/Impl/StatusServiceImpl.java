package com.example.pejon.service.Impl;

import com.example.pejon.model.Role;
import com.example.pejon.model.Status;
import com.example.pejon.model.Type;
import com.example.pejon.repository.StatusRepository;
import com.example.pejon.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    StatusRepository statusRepository;

    @Override
    public List<Status> getAllStatus() {
        return statusRepository.findAll();
    }

    @Override
    public Status getStatusById(Long id) {
        return statusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Status не найден: " + id));
    }

    @Override
    public Status addStatus(Status status) {
        statusRepository.save(status);
        return status;
    }

    @Override
    public Status updateStatusById(Long id, Status status) {
        Status s = statusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Status не найден: " + id));

        s.setName(status.getName());
        s.setTerminal(status.getTerminal());

        statusRepository.save(s);
        return s;
    }

    @Override
    public void deleteStatusById(Long id) {
        Status status = statusRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Role не найден: " + id));
        statusRepository.delete(status);
    }
}
