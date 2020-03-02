package com.nsu.bd.aircraft.dao.accounting;

import com.nsu.bd.aircraft.model.accounting.Stage;
import org.springframework.data.repository.CrudRepository;

public interface StageDao extends CrudRepository<Stage, Integer> {
}
