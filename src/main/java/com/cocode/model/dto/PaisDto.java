package com.cocode.model.dto;

import com.cocode.model.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
@Builder
public class PaisDto implements Serializable {

    private Long id;
    private String codigo;
    private String nombre;
    @JsonIgnore
    private List<Usuario> usuarios;
}
