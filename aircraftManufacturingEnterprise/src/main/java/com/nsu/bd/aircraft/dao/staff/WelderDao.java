package com.nsu.bd.aircraft.dao.staff;

import com.nsu.bd.aircraft.model.staff.Welder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WelderDao extends CrudRepository<Welder, Integer> {
    @Override
    List<Welder> findAll();
}
