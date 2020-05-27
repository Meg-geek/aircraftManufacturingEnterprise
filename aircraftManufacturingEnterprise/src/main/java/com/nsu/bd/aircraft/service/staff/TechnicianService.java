package com.nsu.bd.aircraft.service.staff;

import com.nsu.bd.aircraft.api.dto.staff.EmployeeDto;
import com.nsu.bd.aircraft.dao.staff.TechnicianDao;
import com.nsu.bd.aircraft.service.converters.staff.EmployeeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TechnicianService implements StaffService {
    private final TechnicianDao technicianDao;
    private final EmployeeConverter employeeConverter;

    @Override
    @Transactional
    public void add(EmployeeDto employeeDto) {
        technicianDao.save(employeeConverter.getTechnician(employeeDto));
    }

    @Override
    public List<EmployeeDto> getAll() {
        return employeeConverter.getEmployeeDtos(technicianDao.findAll());
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        technicianDao.deleteById(id);
    }

    @Override
    @Transactional
    public EmployeeDto update(EmployeeDto employeeDto) {
        return employeeConverter
                .getEmployeeDto(technicianDao
                        .save(employeeConverter
                                .getTechnician(employeeDto)));
    }
}
