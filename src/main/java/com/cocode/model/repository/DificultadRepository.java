package com.cocode.model.repository;

import com.cocode.model.entity.Dificultad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DificultadRepository extends CrudRepository<Dificultad, Long> {
}
