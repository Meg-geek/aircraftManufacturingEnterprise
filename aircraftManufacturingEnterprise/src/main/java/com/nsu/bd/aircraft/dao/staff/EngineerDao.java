package com.nsu.bd.aircraft.dao.staff;

import com.nsu.bd.aircraft.model.staff.Engineer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EngineerDao extends CrudRepository<Engineer, Integer> {
    @Override
    List<Engineer> findAll();
}
