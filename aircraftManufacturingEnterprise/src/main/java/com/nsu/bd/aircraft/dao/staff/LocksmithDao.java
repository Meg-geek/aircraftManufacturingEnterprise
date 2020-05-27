package com.nsu.bd.aircraft.dao.staff;

import com.nsu.bd.aircraft.model.staff.Locksmith;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocksmithDao extends CrudRepository<Locksmith, Integer> {
    @Override
    List<Locksmith> findAll();
}
