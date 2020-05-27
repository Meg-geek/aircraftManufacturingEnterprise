package com.nsu.bd.aircraft.controller.staff;

import com.nsu.bd.aircraft.service.staff.TurnerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/aircraft/staff/turners")
public class TurnerController extends StaffController {
    private final TurnerService turnerService;

    public TurnerController(@Autowired TurnerService turnerService) {
        super(turnerService);
        this.turnerService = turnerService;
    }
}
