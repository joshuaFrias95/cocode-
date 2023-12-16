package com.cocode.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "status")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 70, nullable = false)
    private String nombre;

    @OneToMany(targetEntity = Tareas.class, fetch =  FetchType.EAGER, mappedBy = "estado")
    List<Tareas> tareas;
}
