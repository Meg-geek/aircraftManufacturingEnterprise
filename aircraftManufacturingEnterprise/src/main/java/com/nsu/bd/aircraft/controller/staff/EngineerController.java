package com.nsu.bd.aircraft.controller.staff;

import com.nsu.bd.aircraft.service.staff.EngineerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/aircraft/staff/engineers")
public class EngineerController extends StaffController {
    private final EngineerService engineerService;

    public EngineerController(@Autowired EngineerService engineerService) {
        super(engineerService);
        this.engineerService = engineerService;
    }
}
