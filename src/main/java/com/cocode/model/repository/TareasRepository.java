package com.cocode.model.repository;

import com.cocode.model.entity.Tareas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareasRepository extends CrudRepository<Tareas, Long> {
}
