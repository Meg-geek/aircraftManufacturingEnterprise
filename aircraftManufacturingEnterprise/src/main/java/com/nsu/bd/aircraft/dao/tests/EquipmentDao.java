package com.nsu.bd.aircraft.dao.tests;

import com.nsu.bd.aircraft.model.tests.Equipment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EquipmentDao extends CrudRepository<Equipment, Integer> {
    @Override
    List<Equipment> findAll();
}
