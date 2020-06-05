package com.nsu.bd.aircraft.dao.staff;

import com.nsu.bd.aircraft.model.staff.Brigade;
import com.nsu.bd.aircraft.model.staff.Worker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerDao extends CrudRepository<Worker, Integer> {
    List<Worker> getByBrigade(Brigade brigade);
}
