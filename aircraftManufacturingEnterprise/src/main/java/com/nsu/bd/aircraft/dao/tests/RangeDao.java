package com.nsu.bd.aircraft.dao.tests;

import com.nsu.bd.aircraft.model.tests.Range;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RangeDao extends CrudRepository<Range, Integer> {
    @Override
    List<Range> findAll();
}
