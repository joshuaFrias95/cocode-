package com.cocode.service;

import com.cocode.model.entity.Tecnologia;

import java.util.List;

public interface ITecnologia {

    List<Tecnologia> listAll();
    Tecnologia findById(Long id);

}
