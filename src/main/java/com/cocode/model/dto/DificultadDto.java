package com.cocode.model.dto;

import com.cocode.model.entity.Proyecto;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
@Builder
public class DificultadDto implements Serializable {

    private Long id;
    private String name;
    List<Proyecto> proyectos;
}
