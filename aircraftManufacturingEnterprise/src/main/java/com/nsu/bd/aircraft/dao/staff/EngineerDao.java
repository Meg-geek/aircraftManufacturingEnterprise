package com.nsu.bd.aircraft.dao.staff;

import com.nsu.bd.aircraft.model.staff.Engineer;
import org.springframework.data.repository.CrudRepository;

public interface EngineerDao extends CrudRepository<Engineer, Integer> {
}
