package com.cocode.service.impl;

import com.cocode.model.dao.TecnologiasDao;
import com.cocode.model.entity.Tecnologias;
import com.cocode.service.ITecnologias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class TecnologiaService implements ITecnologias {

    @Autowired
    private TecnologiasDao tecnologiasDao;


    @Transactional(readOnly = true)
    @Override
    public List<Tecnologias> listAll() {
        return (List<Tecnologias> ) tecnologiasDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Tecnologias findById(Long id) {
        return tecnologiasDao.findById(id).orElse(null);
    }

}
