package com.nsu.bd.aircraft.dao.staff;

import com.nsu.bd.aircraft.model.staff.Worker;
import org.springframework.data.repository.CrudRepository;

public interface WorkerDao extends CrudRepository<Worker, Integer> {
}
