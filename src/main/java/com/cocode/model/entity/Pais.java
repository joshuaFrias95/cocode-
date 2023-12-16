package com.cocode.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "paises")
public class Pais implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 4, unique = true, nullable = false)
    private String codigo;

    @Column(length = 25, unique = true, nullable = false)
    private String nombre;

    @OneToMany(targetEntity = Usuario.class, fetch = FetchType.LAZY, mappedBy = "pais")
    private List<Usuario> usuarios;
}
