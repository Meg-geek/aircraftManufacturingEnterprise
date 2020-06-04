package com.nsu.bd.aircraft.service.staff;

import com.nsu.bd.aircraft.api.dto.staff.EmployeeDto;
import com.nsu.bd.aircraft.dao.staff.TurnerDao;
import com.nsu.bd.aircraft.service.converters.staff.EmployeeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TurnerService implements StaffService {
    private final TurnerDao turnerDao;
    private final EmployeeConverter employeeConverter;

    @Override
    @Transactional
    public void add(EmployeeDto employeeDto) {
        turnerDao.save(employeeConverter.getTurner(employeeDto));
    }

    @Override
    public List<EmployeeDto> getAll() {
        return employeeConverter.getEmployeeDtos(turnerDao.findAll());
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        turnerDao.deleteById(id);
    }

    @Override
    @Transactional
    public EmployeeDto update(EmployeeDto employeeDto) {
        return employeeConverter
                .getEmployeeDto(turnerDao
                        .save(employeeConverter
                                .getTurner(employeeDto)));
    }

    @Override
    public List<EmployeeDto> getByCompany(int companyId) {
        return employeeConverter
                .getEmployeeDtos(turnerDao.getByCompany(companyId));
    }

    @Override
    public List<EmployeeDto> getByGuild(int guildId) {
        return employeeConverter
                .getEmployeeDtos(turnerDao.getByGuild(guildId));
    }
}
