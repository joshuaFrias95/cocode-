package com.cocode.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tecnologias")
public class Tecnologias implements Serializable {

    @Id
    @Column(name = "tecnologia_id")
    private Long id;

    @Column(name = "nombre_tecnologia")
    private String nombre;
}
