package com.nsu.bd.aircraft.service.converters.staff;

import com.nsu.bd.aircraft.api.dto.staff.EmployeeDto;
import com.nsu.bd.aircraft.model.staff.*;
import com.nsu.bd.aircraft.service.converters.company.SiteConverter;
import com.nsu.bd.aircraft.service.converters.tests.RangeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeConverter {
    private final BrigadeConverter brigadeConverter;
    private final RangeConverter rangeConverter;
    private final SiteConverter siteConverter;

    public Welder getWelder(EmployeeDto employeeDto) {
        if (employeeDto == null) {
            return null;
        }
        return (Welder) getWorker(new Welder(), employeeDto);
    }

    public Turner getTurner(EmployeeDto employeeDto) {
        if (employeeDto == null) {
            return null;
        }
        return (Turner) getWorker(new Turner(), employeeDto);
    }

    public Picker getPicker(EmployeeDto employeeDto) {
        if (employeeDto == null) {
            return null;
        }
        return (Picker) getWorker(new Picker(), employeeDto);
    }

    public Locksmith getLocksmith(EmployeeDto employeeDto) {
        if (employeeDto == null) {
            return null;
        }
        return (Locksmith) getWorker(new Locksmith(), employeeDto);
    }

    public Engineer getEngineer(EmployeeDto employeeDto) {
        if (employeeDto == null) {
            return null;
        }
        Engineer engineer = (Engineer) getEmpoyee(new Engineer(), employeeDto);
        engineer.setSite(siteConverter.getSite(employeeDto.getSite()));
        return engineer;
    }

    public Technician getTechnician(EmployeeDto employeeDto) {
        if (employeeDto == null) {
            return null;
        }
        Technician technician = (Technician) getEmpoyee(new Technician(), employeeDto);
        technician.setSite(siteConverter.getSite(employeeDto.getSite()));
        return technician;
    }

    public Master getMaster(EmployeeDto employeeDto) {
        if (employeeDto == null) {
            return null;
        }
        Master master = (Master) getEmpoyee(new Master(), employeeDto);
        master.setSite(siteConverter.getSite(employeeDto.getSite()));
        return master;
    }


    public Tester getTester(EmployeeDto employeeDto) {
        if (employeeDto == null) {
            return null;
        }
        Tester tester = (Tester) getEmpoyee(new Tester(), employeeDto);
        tester.setRange(rangeConverter.getRange(employeeDto.getRange()));
        return tester;
    }

    public List<EmployeeDto> getEmployeeDtos(List<? extends Employee> employees) {
        if (employees == null) {
            return emptyList();
        }
        return employees.stream()
                .map(this::getEmployeeDto)
                .collect(toList());
    }

    public EmployeeDto getEmployeeDto(Employee employee) {
        if (employee == null) {
            return null;
        }
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setSurname(employee.getSurname());

        if (employee instanceof Worker) {
            employeeDto.setBrigade(brigadeConverter
                    .getBrigadeDto(((Worker) employee).getBrigade()));
            return employeeDto;
        }
        if (employee instanceof Engineer) {
            employeeDto.setSite(siteConverter
                    .getSiteDto(((Engineer) employee).getSite()));
            return employeeDto;
        }
        if (employee instanceof Technician) {
            employeeDto.setSite(siteConverter
                    .getSiteDto(((Technician) employee).getSite()));
            return employeeDto;
        }
        if (employee instanceof Master) {
            employeeDto.setSite(siteConverter
                    .getSiteDto(((Master) employee).getSite()));
            return employeeDto;
        }
        if (employee instanceof Tester) {
            employeeDto.setRange(rangeConverter.getRangeDto(((Tester) employee).getRange()));
        }
        return employeeDto;
    }

    private Worker getWorker(Worker worker, EmployeeDto employeeDto) {
        getEmpoyee(worker, employeeDto);
        worker.setBrigade(brigadeConverter.getBrigade(employeeDto.getBrigade()));
        return worker;
    }

    private Employee getEmpoyee(Employee employee, EmployeeDto employeeDto) {
        employee.setId(employeeDto.getId());
        employee.setName(employeeDto.getName());
        employee.setSurname(employeeDto.getSurname());
        return employee;
    }
}