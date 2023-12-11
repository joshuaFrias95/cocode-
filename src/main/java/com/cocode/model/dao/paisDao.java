package com.cocode.model.dao;

import com.cocode.model.entity.Pais;
import org.springframework.data.repository.CrudRepository;

public interface paisDao extends CrudRepository<Pais,Long> {
}
