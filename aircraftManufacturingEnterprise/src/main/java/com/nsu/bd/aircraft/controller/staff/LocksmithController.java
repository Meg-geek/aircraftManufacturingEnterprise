package com.nsu.bd.aircraft.controller.staff;

import com.nsu.bd.aircraft.api.GeneralResponse;
import com.nsu.bd.aircraft.api.dto.staff.EmployeeDto;
import com.nsu.bd.aircraft.service.staff.LocksmithService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/aircraft/staff/locksmiths")
public class LocksmithController extends StaffController {
    private final LocksmithService locksmithService;

    public LocksmithController(@Autowired LocksmithService locksmithService) {
        super(locksmithService);
        this.locksmithService = locksmithService;
    }


    @GetMapping("/get-without-brigade")
    public GeneralResponse<List<EmployeeDto>> getFreeWorkers() {
        return new GeneralResponse<>(locksmithService.getFreeWorkers());
    }
}
