package com.cocode.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "dificultades")
public class Dificultad implements Serializable {

    @Id
    @Column(name = "dificultad_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_dificultad")
    private String nombre;
}
