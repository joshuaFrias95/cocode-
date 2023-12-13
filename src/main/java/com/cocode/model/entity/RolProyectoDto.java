package com.cocode.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@Builder
public class RolProyectoDto implements Serializable {

    private Long id;
    private String nombre;
}
