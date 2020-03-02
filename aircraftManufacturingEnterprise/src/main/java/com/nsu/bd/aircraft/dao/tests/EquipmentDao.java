package com.nsu.bd.aircraft.dao.tests;

import com.nsu.bd.aircraft.model.tests.Equipment;
import org.springframework.data.repository.CrudRepository;

public interface EquipmentDao extends CrudRepository<Equipment, Integer> {
}
