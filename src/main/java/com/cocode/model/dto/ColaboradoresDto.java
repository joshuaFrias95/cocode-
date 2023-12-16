package com.cocode.model.dto;

import com.cocode.model.entity.Usuario;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@Builder
public class ColaboradoresDto implements Serializable {

    private Long id;
    private Usuario colaboradores;
}
