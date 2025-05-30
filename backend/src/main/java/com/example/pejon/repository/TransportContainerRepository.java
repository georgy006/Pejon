package com.example.pejon.repository;

import com.example.pejon.model.TransportContainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportContainerRepository extends JpaRepository<TransportContainer, Long> {
}
