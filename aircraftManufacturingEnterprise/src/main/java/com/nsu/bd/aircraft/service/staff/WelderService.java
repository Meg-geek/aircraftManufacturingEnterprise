package com.nsu.bd.aircraft.service.staff;

import com.nsu.bd.aircraft.api.dto.staff.EmployeeDto;
import com.nsu.bd.aircraft.dao.staff.WelderDao;
import com.nsu.bd.aircraft.service.converters.staff.EmployeeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WelderService implements StaffService {
    private final WelderDao welderDao;
    private final EmployeeConverter employeeConverter;

    @Override
    @Transactional
    public void add(EmployeeDto employeeDto) {
        welderDao.save(employeeConverter.getWelder(employeeDto));
    }

    @Override
    public List<EmployeeDto> getAll() {
        return employeeConverter.getEmployeeDtos(welderDao.findAll());
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        welderDao.deleteById(id);
    }

    @Override
    @Transactional
    public EmployeeDto update(EmployeeDto employeeDto) {
        return employeeConverter
                .getEmployeeDto(welderDao
                        .save(employeeConverter
                                .getWelder(employeeDto)));
    }

    @Override
    public List<EmployeeDto> getByCompany(int companyId) {
        return employeeConverter
                .getEmployeeDtos(welderDao.getByCompany(companyId));
    }

    @Override
    public List<EmployeeDto> getByGuild(int guildId) {
        return employeeConverter
                .getEmployeeDtos(welderDao.getByGuild(guildId));
    }

    public List<EmployeeDto> getFreeWorkers() {
        return employeeConverter
                .getEmployeeDtos(welderDao.getFreeWorkers());
    }
}
