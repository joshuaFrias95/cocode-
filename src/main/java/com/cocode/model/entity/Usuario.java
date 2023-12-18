package com.cocode.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    private String nombre;

    @Column(length = 25, nullable = false)
    private String apellido;

    @Email
    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "pais")
    private Pais pais;

    @Column(length = 250)
    private String descripcion;

    @Column(length = 30)
    private String rol;

    private String avatar;

    @Column(columnDefinition="int")
    private Integer puntos;


    @JsonIgnore
    @OneToMany(targetEntity = Colaboradores.class, fetch = FetchType.EAGER, mappedBy = "colaboradores")
    private List<Colaboradores> colaboradores;

    @JsonIgnore
    @ManyToMany(targetEntity = Tecnologia.class, fetch = FetchType.EAGER)
    @JoinTable(name = "tecnologias_usuario", joinColumns = @JoinColumn(name = "usuario"), inverseJoinColumns = @JoinColumn(name = "tecnologia"))
    private List<Tecnologia> tecnologias;

    @JsonIgnore
    @ManyToMany(targetEntity = Proyecto.class, fetch = FetchType.LAZY)
    @JoinTable(name = "proyectos_usuario", joinColumns = @JoinColumn(name = "usuario"), inverseJoinColumns = @JoinColumn(name = "proyecto"))
    private List<Proyecto> proyectos;

    @JsonIgnore
    @ManyToMany(targetEntity = Proyecto.class, fetch = FetchType.LAZY)
    @JoinTable(name = "proyectos_favoritos", joinColumns = @JoinColumn(name = "usuario"), inverseJoinColumns = @JoinColumn(name = "proyecto"))
    private List<Proyecto> proyectosFavoritos;


}
