package com.cocode.service;

import com.cocode.model.entity.Tecnologias;

import java.util.List;

public interface ITecnologias {

    List<Tecnologias> listAll();
    Tecnologias findById(Long id);

}
