package com.nsu.bd.aircraft.service.staff;

import com.nsu.bd.aircraft.api.dto.staff.EmployeeDto;
import com.nsu.bd.aircraft.dao.staff.EngineerDao;
import com.nsu.bd.aircraft.service.converters.staff.EmployeeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EngineerService implements StaffService {
    private final EngineerDao engineerDao;
    private final EmployeeConverter employeeConverter;

    @Override
    @Transactional
    public void add(EmployeeDto employeeDto) {
        engineerDao.save(employeeConverter.getEngineer(employeeDto));
    }

    @Override
    public List<EmployeeDto> getAll() {
        return employeeConverter.getEmployeeDtos(engineerDao.findAll());
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        engineerDao.deleteById(id);
    }

    @Override
    @Transactional
    public EmployeeDto update(EmployeeDto employeeDto) {
        return employeeConverter
                .getEmployeeDto(engineerDao
                        .save(employeeConverter
                                .getEngineer(employeeDto)));
    }
}
