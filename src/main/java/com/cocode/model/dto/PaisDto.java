package com.cocode.model.dto;

import com.cocode.model.entity.Usuario;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@Builder
public class PaisDto {

    private Long id;
    private String codigo;
    private List<Usuario> usuarios;
}
