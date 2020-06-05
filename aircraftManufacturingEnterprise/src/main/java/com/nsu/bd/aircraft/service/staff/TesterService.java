package com.nsu.bd.aircraft.service.staff;

import com.nsu.bd.aircraft.api.dto.staff.EmployeeDto;
import com.nsu.bd.aircraft.dao.staff.TesterDao;
import com.nsu.bd.aircraft.service.converters.staff.EmployeeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TesterService implements StaffService {
    private final TesterDao testerDao;
    private final EmployeeConverter employeeConverter;

    @Override
    @Transactional
    public void add(EmployeeDto employeeDto) {
        testerDao.save(employeeConverter.getTester(employeeDto));
    }

    @Override
    public List<EmployeeDto> getAll() {
        return employeeConverter.getEmployeeDtos(testerDao.findAll());
    }

    @Override
    @Transactional
    public void deleteById(int testerId) {
        testerDao.deleteById(testerId);
    }

    @Override
    @Transactional
    public EmployeeDto update(EmployeeDto employeeDto) {
        return employeeConverter
                .getEmployeeDto(testerDao
                        .save(employeeConverter
                                .getTester(employeeDto)));
    }

    @Override
    public List<EmployeeDto> getByCompany(int companyId) {
        return emptyList();
    }

    @Override
    public List<EmployeeDto> getByGuild(int guildId) {
        return emptyList();
    }

    public List<EmployeeDto> getByProductAndRangeAndDateInterval(
            int productId,
            int rangeId,
            long beginDate,
            long endDate) {
        if (endDate == 0) {
            return employeeConverter
                    .getEmployeeDtos(testerDao
                            .getByProductAndRangeAndDateInterval(productId, rangeId,
                                    new Date(beginDate), new Date(System.currentTimeMillis())));
        }
        return employeeConverter
                .getEmployeeDtos(testerDao
                        .getByProductAndRangeAndDateInterval(productId, rangeId,
                                new Date(beginDate), new Date(endDate)));
    }

    public List<EmployeeDto> getByRangeAndDateIntervalAndHangGlider(int rangeId,
                                                                    long beginDate,
                                                                    long endDate) {
        if (endDate == 0) {
            return employeeConverter
                    .getEmployeeDtos(testerDao
                            .getByRangeAndDateIntervalAndHangGlider(rangeId,
                                    new Date(beginDate), new Date(System.currentTimeMillis())));
        }
        return employeeConverter
                .getEmployeeDtos(testerDao
                        .getByRangeAndDateIntervalAndHangGlider(rangeId,
                                new Date(beginDate), new Date(endDate)));
    }

    public List<EmployeeDto> getByRangeAndDateIntervalAndHelicopter(int rangeId,
                                                                    long beginDate,
                                                                    long endDate) {
        if (endDate == 0) {
            return employeeConverter
                    .getEmployeeDtos(testerDao
                            .getByRangeAndDateIntervalAndHelicopter(rangeId,
                                    new Date(beginDate), new Date(System.currentTimeMillis())));
        }
        return employeeConverter
                .getEmployeeDtos(testerDao
                        .getByRangeAndDateIntervalAndHelicopter(rangeId,
                                new Date(beginDate), new Date(endDate)));
    }

    public List<EmployeeDto> getByRangeAndDateIntervalAndPlane(int rangeId,
                                                               long beginDate,
                                                               long endDate) {
        if (endDate == 0) {
            return employeeConverter
                    .getEmployeeDtos(testerDao
                            .getByRangeAndDateIntervalAndPlane(rangeId,
                                    new Date(beginDate), new Date(System.currentTimeMillis())));
        }
        return employeeConverter
                .getEmployeeDtos(testerDao
                        .getByRangeAndDateIntervalAndPlane(rangeId,
                                new Date(beginDate), new Date(endDate)));
    }

    public List<EmployeeDto> getByRangeAndDateIntervalAndRocket(int rangeId,
                                                                long beginDate,
                                                                long endDate) {
        if (endDate == 0) {
            return employeeConverter
                    .getEmployeeDtos(testerDao
                            .getByRangeAndDateIntervalAndRocket(rangeId,
                                    new Date(beginDate), new Date(System.currentTimeMillis())));
        }
        return employeeConverter
                .getEmployeeDtos(testerDao
                        .getByRangeAndDateIntervalAndRocket(rangeId,
                                new Date(beginDate), new Date(endDate)));
    }

    public List<EmployeeDto> getByRangeAndDateInterval(int rangeId,
                                                       long beginDate,
                                                       long endDate) {
        if (endDate == 0) {
            return employeeConverter
                    .getEmployeeDtos(testerDao
                            .getByRangeAndDateInterval(rangeId,
                                    new Date(beginDate), new Date(System.currentTimeMillis())));
        }
        return employeeConverter
                .getEmployeeDtos(testerDao
                        .getByRangeAndDateInterval(rangeId,
                                new Date(beginDate), new Date(endDate)));
    }
}
