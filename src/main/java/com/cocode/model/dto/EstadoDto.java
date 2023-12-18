package com.cocode.model.dto;

import com.cocode.model.entity.Tareas;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
@Builder
public class EstadoDto implements Serializable {

    private Long id;
    private String nombre;
    @JsonIgnore
    List<Tareas> tareas;
}
