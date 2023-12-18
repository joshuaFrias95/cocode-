package com.cocode.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dificultades")
public class Dificultad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 15, unique = true, nullable = false)
    private String nombre;

    @JsonIgnore
    @OneToMany(targetEntity = Proyecto.class, fetch = FetchType.LAZY, mappedBy = "dificultad")
    private List<Proyecto> proyectos;
}
