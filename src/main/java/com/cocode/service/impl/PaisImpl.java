package com.cocode.service.impl;

import com.cocode.model.dao.PaisDao;
import com.cocode.model.entity.Pais;
import com.cocode.service.IPais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaisImpl implements IPais {

    @Autowired
    private PaisDao paisDao;

    @Override
    public List<Pais> listAll() {
        return (List<Pais>) paisDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Pais findById(Long id) {
        return paisDao.findById(id).orElse(null);
    }

    @Override
    public boolean existByID(Long id) {
        return paisDao.existsById(id);
    }
}
