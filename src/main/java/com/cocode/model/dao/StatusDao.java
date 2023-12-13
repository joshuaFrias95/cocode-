package com.cocode.model.dao;

import com.cocode.model.entity.Status;
import org.springframework.data.repository.CrudRepository;

public interface StatusDao extends CrudRepository<Status, Long> {
}
