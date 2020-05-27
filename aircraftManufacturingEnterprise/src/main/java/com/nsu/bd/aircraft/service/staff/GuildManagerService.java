package com.nsu.bd.aircraft.service.staff;

import com.nsu.bd.aircraft.api.dto.staff.EmployeeDto;
import com.nsu.bd.aircraft.dao.staff.GuildManagerDao;
import com.nsu.bd.aircraft.service.converters.staff.EmployeeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GuildManagerService implements StaffService {
    private final GuildManagerDao guildManagerDao;
    private final EmployeeConverter employeeConverter;

    @Override
    @Transactional
    public void add(EmployeeDto employeeDto) {
        guildManagerDao.save(employeeConverter.getGuildManager(employeeDto));
    }

    @Override
    public List<EmployeeDto> getAll() {
        return employeeConverter.getEmployeeDtos(guildManagerDao.findAll());
    }

    @Override
    @Transactional
    public void deleteById(int guildManagerId) {
        guildManagerDao.deleteById(guildManagerId);
    }

    @Override
    @Transactional
    public EmployeeDto update(EmployeeDto employeeDto) {
        return employeeConverter
                .getEmployeeDto(guildManagerDao
                        .save(employeeConverter
                                .getGuildManager(employeeDto)));
    }
}
