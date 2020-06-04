package com.nsu.bd.aircraft.service.staff;


import com.nsu.bd.aircraft.api.dto.staff.EmployeeDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StaffService {
    @Transactional
    void add(EmployeeDto employeeDto);

    List<EmployeeDto> getAll();

    @Transactional
    void deleteById(int id);

    @Transactional
    EmployeeDto update(EmployeeDto employeeDto);

    List<EmployeeDto> getByCompany(int companyId);

    List<EmployeeDto> getByGuild(int guildId);
}
