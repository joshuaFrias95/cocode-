package com.cocode.service.impl;

import com.cocode.model.entity.Dificultad;
import com.cocode.model.repository.DificultadRepository;
import com.cocode.service.IDificultad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DificultadService implements IDificultad {
    
    @Autowired
    private DificultadRepository dificultadRepository;
    
    @Transactional(readOnly = true)
    @Override
    public List<Dificultad> listAll() {
        return (List<Dificultad>) dificultadRepository.findAll();
    }

    @Override
    public Dificultad findById(Long id) {
        return dificultadRepository.findById(id).orElse(null);
    }
}
