package com.nsu.bd.aircraft.dao.tests;

import com.nsu.bd.aircraft.model.company.Guild;
import com.nsu.bd.aircraft.model.tests.Test;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TestDao extends CrudRepository<Test, Integer> {
    @Override
    List<Test> findAll();

    List<Test> findByGuild(Guild guild);
}
