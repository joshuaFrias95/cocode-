package com.cocode.service.impl;

import com.cocode.model.entity.Estado;
import com.cocode.model.repository.EstadoRepository;
import com.cocode.service.IEstado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService implements IEstado {


    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public List<Estado> listAll() {
        return (List<Estado>) estadoRepository.findAll();
    }

    @Override
    public Estado GetById(Long id) {
        return estadoRepository.findById(id).orElse(null);
    }
}
