package com.cocode.model.repository;

import com.cocode.model.entity.Tecnologia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnologiaRepository extends CrudRepository<Tecnologia, Long> {
}
