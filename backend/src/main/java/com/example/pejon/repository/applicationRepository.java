package com.example.pejon.repository;

import com.example.pejon.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface applicationRepository extends JpaRepository<Application,Long> {
}
