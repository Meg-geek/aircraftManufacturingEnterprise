package com.nsu.bd.aircraft.dao.staff;

import com.nsu.bd.aircraft.model.staff.Technician;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnicianDao extends CrudRepository<Technician, Integer> {
    @Override
    List<Technician> findAll();
}
