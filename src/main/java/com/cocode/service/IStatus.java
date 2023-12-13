package com.cocode.service;

import com.cocode.model.entity.Status;

import java.util.List;

public interface IStatus {

    List<Status> listAll();
    Status findById(Long id);

}
