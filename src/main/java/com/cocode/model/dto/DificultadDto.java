package com.cocode.model.dto;

import com.cocode.model.entity.Proyecto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@ToString
public class DificultadDto implements Serializable {

    private Long id;
    private String nombre;
    @JsonIgnore
    private List<Proyecto> proyectos;
}
