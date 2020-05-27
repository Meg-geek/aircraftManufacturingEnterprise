package com.nsu.bd.aircraft.dao.staff;

import com.nsu.bd.aircraft.model.staff.Turner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurnerDao extends CrudRepository<Turner, Integer> {
    @Override
    List<Turner> findAll();
}
