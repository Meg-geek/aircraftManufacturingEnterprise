package com.nsu.bd.aircraft.dao.staff;

import com.nsu.bd.aircraft.model.staff.Tester;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TesterDao extends CrudRepository<Tester, Integer> {
    @Override
    List<Tester> findAll();
}
