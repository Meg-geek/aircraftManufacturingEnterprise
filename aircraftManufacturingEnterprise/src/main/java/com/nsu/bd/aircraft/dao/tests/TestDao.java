package com.nsu.bd.aircraft.dao.tests;

import com.nsu.bd.aircraft.model.tests.Test;
import org.springframework.data.repository.CrudRepository;

public interface TestDao extends CrudRepository<Test, Integer> {
}
