package com.cocode.service;


import com.cocode.model.entity.Pais;

public interface ICatalogue {

    Pais findById(Long id);
}
