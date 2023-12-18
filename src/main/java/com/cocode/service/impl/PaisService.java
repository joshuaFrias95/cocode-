package com.cocode.service.impl;

import com.cocode.model.entity.Pais;
import com.cocode.model.repository.PaisRepository;
import com.cocode.service.IPais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaisService implements IPais {

    @Autowired
    private PaisRepository paisRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Pais> listAll() {
        return (List<Pais>) paisRepository.findAll();
    }

    @Override
    public Pais findById(Long id) {
        return paisRepository.findById(id).orElse(null);
    }
}
