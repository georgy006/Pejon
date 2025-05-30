package com.example.pejon.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shelf")
@PrimaryKeyJoinColumn(name = "id")
public class Shelf extends Storage {
    @ManyToOne
    @JoinColumn(name = "line_id")
    private Line line;
}