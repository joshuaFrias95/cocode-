package com.cocode.service.impl;

import com.cocode.model.dao.TecnologiaDao;
import com.cocode.model.entity.Tecnologia;
import com.cocode.service.ITecnologia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TecnologiaService implements ITecnologia {

    @Autowired
    private TecnologiaDao tecnologiasDao;

    @Transactional(readOnly = true)
    @Override
    public List<Tecnologia> listAll() {
        return (List<Tecnologia>) tecnologiasDao.findAll() ;
    }

    @Transactional(readOnly = true)
    @Override
    public Tecnologia findById(Long id) {
        return tecnologiasDao.findById(id).orElse(null);
    }
}
