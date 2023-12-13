package com.cocode.service.impl;

import com.cocode.model.dao.StatusDao;
import com.cocode.model.entity.Status;
import com.cocode.service.IStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StatusService implements IStatus {

    @Autowired
    private StatusDao statusDao;

    @Transactional(readOnly = true)
    @Override
    public List<Status> listAll() {
        return (List<Status>) statusDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Status findById(Long id) {
        return statusDao.findById(id).orElse(null);
    }
}
