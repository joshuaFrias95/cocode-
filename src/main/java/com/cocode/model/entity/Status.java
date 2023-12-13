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
@Table(name = "status")
public class Status implements Serializable {

    @Id
    @Column(name = "status_id")
    private Long id;
    @Column(name = "nombre_status")
    private String nombre;
}
