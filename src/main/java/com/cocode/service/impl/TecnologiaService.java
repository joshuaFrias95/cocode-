package com.cocode.service.impl;

import com.cocode.model.entity.Tecnologia;
import com.cocode.model.repository.TecnologiaRepository;
import com.cocode.service.ITecnologia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TecnologiaService implements ITecnologia {

    @Autowired
    private TecnologiaRepository tecnologiaRepository;

    @Override
    public List<Tecnologia> listAll() {
        return (List<Tecnologia>) tecnologiaRepository.findAll();
    }

    @Override
    public Tecnologia findById(Long id) {
        return tecnologiaRepository.findById(id).orElse(null);
    }
}
