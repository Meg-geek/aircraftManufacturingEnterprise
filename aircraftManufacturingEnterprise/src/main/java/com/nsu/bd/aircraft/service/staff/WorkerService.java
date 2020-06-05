package com.nsu.bd.aircraft.service.staff;

import com.nsu.bd.aircraft.api.dto.staff.BrigadeDto;
import com.nsu.bd.aircraft.api.dto.staff.EmployeeDto;
import com.nsu.bd.aircraft.dao.staff.WorkerDao;
import com.nsu.bd.aircraft.service.converters.staff.BrigadeConverter;
import com.nsu.bd.aircraft.service.converters.staff.EmployeeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WorkerService {
    private final WorkerDao workerDao;
    private final EmployeeConverter employeeConverter;
    private final BrigadeConverter brigadeConverter;

    public List<EmployeeDto> getByBrigade(BrigadeDto brigadeDto) {
        return employeeConverter
                .getEmployeeDtos(workerDao
                        .getByBrigade(brigadeConverter.getBrigade(brigadeDto)));
    }
}
