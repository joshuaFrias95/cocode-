package com.cocode.service;

import com.cocode.model.entity.Estado;

import java.util.List;

public interface IEstado {

    List<Estado> listAll();

    Estado GetById(Long id);
}
