package com.nsu.bd.aircraft.dao.staff;

import com.nsu.bd.aircraft.model.staff.Master;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MasterDao extends CrudRepository<Master, Integer> {
    @Override
    List<Master> findAll();
}
