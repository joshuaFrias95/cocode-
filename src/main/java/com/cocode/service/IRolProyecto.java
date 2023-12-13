package com.cocode.service;

import com.cocode.model.entity.RolProyecto;

import java.util.List;

public interface IRolProyecto {

    List<RolProyecto> listAll();
    RolProyecto findById(Long id);
}
