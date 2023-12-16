package com.cocode.model.dto;

import com.cocode.model.entity.Colaboradores;
import com.cocode.model.entity.Estado;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@Builder
public class TareasDto implements Serializable {

    private Long id;
    private Colaboradores colaborador;
    private String nombre;
    private String descripcion;
    private Estado estado;
}
