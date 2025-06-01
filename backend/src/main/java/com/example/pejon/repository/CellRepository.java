package com.example.pejon.repository;

import com.example.pejon.model.Cell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CellRepository extends JpaRepository<Cell, Long> {
    List<Cell> findAllByStorage_Id(Long storageId);
    List<Cell> findByTransportContainer_NameContainingIgnoreCase(String name);
}
