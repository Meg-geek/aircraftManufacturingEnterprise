package com.nsu.bd.aircraft.dao.accounting;

import com.nsu.bd.aircraft.model.accounting.Stage;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StageDao extends CrudRepository<Stage, Integer> {
    @Override
    List<Stage> findAll();
}
