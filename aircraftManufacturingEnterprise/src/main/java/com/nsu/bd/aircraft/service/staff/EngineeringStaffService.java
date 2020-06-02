package com.nsu.bd.aircraft.service.staff;

import com.nsu.bd.aircraft.api.dto.staff.EmployeeDto;
import com.nsu.bd.aircraft.dao.staff.EngineeringStaffDao;
import com.nsu.bd.aircraft.model.staff.EngineeringStaff;
import com.nsu.bd.aircraft.service.converters.staff.EmployeeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EngineeringStaffService {
    private final EngineeringStaffDao engineeringStaffDao;
    private final EmployeeConverter employeeConverter;

    public EmployeeDto getById(int id) {
        Optional<EngineeringStaff> person = engineeringStaffDao.findById(id);
        if (person.isEmpty()) {
            return new EmployeeDto();
        }
        return employeeConverter.getEmployeeDto(person.get());
    }

    private List<EmployeeDto> findByIds(List<Integer> ids) {
        Iterable<EngineeringStaff> engineeringStaff = engineeringStaffDao.findAllById(ids);
        List<EngineeringStaff> engineeringStaffList = new ArrayList<>();
        for (EngineeringStaff staff : engineeringStaff) {
            engineeringStaffList.add(staff);
        }
        return employeeConverter.getEmployeeDtos(engineeringStaffList);
    }

    public List<EmployeeDto> getFreeStaff() {
        List<Integer> managerIds = new ArrayList<>();
        managerIds.addAll(engineeringStaffDao.getGuildManagerIds());
        managerIds.addAll(engineeringStaffDao.getSiteManagerIds());
        return employeeConverter
                .getEmployeeDtos(engineeringStaffDao.getFreeEngineeringStaff(managerIds));
    }

    public List<EmployeeDto> getGuildManagers() {
        List<Integer> managerIds = new ArrayList<>(engineeringStaffDao.getGuildManagerIds());
        return findByIds(managerIds);
    }

    public List<EmployeeDto> getSiteManagers() {
        List<Integer> managerIds = new ArrayList<>(engineeringStaffDao.getSiteManagerIds());
        return findByIds(managerIds);
    }

    public List<EmployeeDto> getFreeStaffForGuildManager(int guildId) {
        List<EmployeeDto> freeStaff = getFreeStaff();
        List<EmployeeDto> freeInGuild = new ArrayList<>();
        for (EmployeeDto staff : freeStaff) {
            if (staff.getSite().getGuild().getId() == guildId) {
                freeInGuild.add(staff);
            }
        }
        return freeInGuild;
    }
}
