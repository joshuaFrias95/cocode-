package com.cocode.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "rol_proyecto")
public class RolProyecto {

    @Id
    @Column(name = "proyecto_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_rol_proyecto")
    private String nombre;
}
