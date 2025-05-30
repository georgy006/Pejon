package com.example.pejon.repository;

import com.example.pejon.model.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Long> {
    List<Zone> findAllByWarehouseId(Long warehouseId);
    List<Zone> findAllByWarehouse_Id(Long warehouseId);


}
