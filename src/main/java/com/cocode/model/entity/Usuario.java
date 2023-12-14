package com.cocode.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @Column(name = "usuario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    @Email
    private String email;
    private String password;
    @OneToOne(targetEntity = Pais.class)
    @JoinColumn(name = "pais")
    private Pais pais;
    private String descripcion;
    private String puesto;
    private String avatar;
    private Integer puntos = 50;
}
