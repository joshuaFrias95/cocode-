package com.cocode.model.entity;

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
@Table(name = "proyectos")
public class Proyecto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 70, nullable = false)
    private String nombre;

    @Column(length = 250)
    private String descripcion;

    private String portada;

    @OneToOne(targetEntity = Colaboradores.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "colaborador")
    private Colaboradores colaboradores;

    @OneToOne(targetEntity = Tareas.class, cascade = CascadeType.ALL)
    private Tareas tareas;

    @ManyToOne
    @JoinColumn(name = "dificultad", nullable = false)
    private Dificultad dificultad;




    @ManyToMany(targetEntity = Tecnologia.class, fetch = FetchType.EAGER)
    @JoinTable(name = "tecnologias_proyecto", joinColumns = @JoinColumn(name = "proyecto"), inverseJoinColumns = @JoinColumn(name = "tecnologia"))
    private List<Tecnologia> tecnologias;
}
