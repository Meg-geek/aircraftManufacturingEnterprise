package com.nsu.bd.aircraft.dao.staff;

import com.nsu.bd.aircraft.model.staff.EngineeringStaff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineeringStaffDao extends CrudRepository<EngineeringStaff, Integer> {
}
