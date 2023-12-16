package com.cocode.model.dto;

import com.cocode.model.entity.Colaboradores;
import com.cocode.model.entity.Dificultad;
import com.cocode.model.entity.Tareas;
import com.cocode.model.entity.Tecnologia;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
@Builder
public class ProyectoDto implements Serializable {

    private Long id;
    private String nombre;
    private String descripcion;
    private String portada;
    private Colaboradores colaboradores;
    private Tareas tareas;
    private Dificultad dificultad;

    private List<Tecnologia> tecnologias;
}
