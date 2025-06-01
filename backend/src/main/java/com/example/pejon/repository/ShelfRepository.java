package com.example.pejon.repository;

import com.example.pejon.model.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShelfRepository extends JpaRepository<Shelf,Long> {
    List<Shelf> findByLineId(Long lineId);

}
