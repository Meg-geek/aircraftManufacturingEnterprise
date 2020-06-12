package com.nsu.bd.aircraft.controller.staff;

import com.nsu.bd.aircraft.api.GeneralResponse;
import com.nsu.bd.aircraft.api.dto.staff.EmployeeDto;
import com.nsu.bd.aircraft.service.staff.TurnerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/aircraft/staff/turners")
public class TurnerController extends StaffController {
    private final TurnerService turnerService;

    public TurnerController(@Autowired TurnerService turnerService) {
        super(turnerService);
        this.turnerService = turnerService;
    }


    @GetMapping("/get-without-brigade")
    public GeneralResponse<List<EmployeeDto>> getFreeWorkers() {
        return new GeneralResponse<>(turnerService.getFreeWorkers());
    }
}
