package com.example.pejon.repository;

import com.example.pejon.model.Line;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinesRepository extends JpaRepository<Line, Long> {
    List<Line> findAllByWarehouseId(Long warehouseId);
}
