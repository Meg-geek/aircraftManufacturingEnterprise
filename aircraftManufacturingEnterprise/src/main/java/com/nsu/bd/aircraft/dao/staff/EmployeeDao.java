package com.nsu.bd.aircraft.dao.staff;

import com.nsu.bd.aircraft.model.staff.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {
    @Override
    List<Employee> findAll();
}
