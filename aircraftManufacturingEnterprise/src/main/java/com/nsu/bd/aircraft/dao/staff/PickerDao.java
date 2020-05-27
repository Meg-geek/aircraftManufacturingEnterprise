package com.nsu.bd.aircraft.dao.staff;

import com.nsu.bd.aircraft.model.staff.Picker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PickerDao extends CrudRepository<Picker, Integer> {
    @Override
    List<Picker> findAll();
}
