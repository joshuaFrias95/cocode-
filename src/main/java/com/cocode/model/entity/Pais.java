package com.cocode.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "paises")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 4, unique = true, nullable = false)
    private String codigo;
    @Column(length = 25, unique = true, nullable = false)
    private String nombre;
}
