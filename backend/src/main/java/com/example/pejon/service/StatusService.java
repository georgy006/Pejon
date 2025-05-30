package com.example.pejon.service;


import com.example.pejon.model.Status;

import java.util.List;

public interface StatusService {
    List<Status> getAllStatus();
    Status getStatusById(Long id);
    Status addStatus(Status type);
    Status updateStatusById(Long id, Status type);
    void deleteStatusById(Long id);

}
