package com.example.pejon.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "floor_zone")
@PrimaryKeyJoinColumn(name = "id")
public class Zone extends Storage {
    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;
}