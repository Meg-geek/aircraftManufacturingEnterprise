package com.nsu.bd.aircraft.service.staff;

import com.nsu.bd.aircraft.api.dto.company.SiteDto;
import com.nsu.bd.aircraft.api.dto.staff.EmployeeDto;
import com.nsu.bd.aircraft.dao.staff.MasterDao;
import com.nsu.bd.aircraft.service.converters.company.SiteConverter;
import com.nsu.bd.aircraft.service.converters.staff.EmployeeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MasterService implements StaffService {
    private final MasterDao masterDao;
    private final EmployeeConverter employeeConverter;
    private final SiteConverter siteConverter;

    @Override
    @Transactional
    public void add(EmployeeDto employeeDto) {
        masterDao.save(employeeConverter.getMaster(employeeDto));
    }

    @Override
    public List<EmployeeDto> getAll() {
        return employeeConverter.getEmployeeDtos(masterDao.findAll());
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        masterDao.deleteById(id);
    }

    @Override
    @Transactional
    public EmployeeDto update(EmployeeDto employeeDto) {
        return employeeConverter
                .getEmployeeDto(masterDao
                        .save(employeeConverter
                                .getMaster(employeeDto)));
    }

    @Override
    public List<EmployeeDto> getByCompany(int companyId) {
        return employeeConverter
                .getEmployeeDtos(masterDao.getByCompany(companyId));
    }

    @Override
    public List<EmployeeDto> getByGuild(int guildId) {
        return employeeConverter
                .getEmployeeDtos(masterDao.getByGuild(guildId));
    }

    public List<EmployeeDto> getBySite(SiteDto siteDto) {
        return employeeConverter.getEmployeeDtos(
                masterDao.getBySite(siteConverter.getSite(siteDto)));
    }
}
