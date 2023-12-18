package com.cocode.service;

import com.cocode.model.entity.Dificultad;

import java.util.List;

public interface IDificultad {

    List<Dificultad> listAll();

    Dificultad findById(Long id);
}
