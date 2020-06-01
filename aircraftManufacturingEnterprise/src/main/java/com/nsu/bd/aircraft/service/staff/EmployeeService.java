package com.nsu.bd.aircraft.service.staff;

import com.nsu.bd.aircraft.api.dto.staff.EmployeeDto;
import com.nsu.bd.aircraft.dao.staff.EmployeeDao;
import com.nsu.bd.aircraft.service.converters.staff.EmployeeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeService {
    private final EmployeeDao employeeDao;
    private final EmployeeConverter employeeConverter;

    public List<EmployeeDto> getAll() {
        return employeeConverter.getEmployeeDtos(employeeDao.findAll());
    }
}
