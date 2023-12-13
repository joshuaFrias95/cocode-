package com.cocode.service;

import com.cocode.model.entity.RolProyecto;
import com.cocode.model.entity.RolProyectoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RolProyectoService implements IRolProyecto {

    @Autowired
    private RolProyectoDao rolProyectoDao;

    @Transactional(readOnly = true)
    @Override
    public List<RolProyecto> listAll() {
        return (List<RolProyecto>)  rolProyectoDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public RolProyecto findById(Long id) {
        return rolProyectoDao.findById(id).orElse(null);
    }
}
