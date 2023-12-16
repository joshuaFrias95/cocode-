package com.cocode.model.repository;

import com.cocode.model.entity.Colaboradores;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradoresRepository extends CrudRepository<Colaboradores, Long> {
}
