package com.nsu.bd.aircraft.controller.staff;

import com.nsu.bd.aircraft.api.GeneralResponse;
import com.nsu.bd.aircraft.api.dto.staff.EmployeeDto;
import com.nsu.bd.aircraft.service.staff.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/aircraft/staff/all")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/get-all")
    public GeneralResponse<List<EmployeeDto>> getAll() {
        return new GeneralResponse<>(employeeService.getAll());
    }
}
