package com.nsu.bd.aircraft.dao.staff;

import com.nsu.bd.aircraft.model.staff.Brigade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrigadeDao extends CrudRepository<Brigade, Integer> {
    @Override
    List<Brigade> findAll();
}
