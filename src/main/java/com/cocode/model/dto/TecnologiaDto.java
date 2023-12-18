package com.cocode.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@Builder
@ToString
public class TecnologiaDto implements Serializable {

    private Long id;
    private String nombre;
}
