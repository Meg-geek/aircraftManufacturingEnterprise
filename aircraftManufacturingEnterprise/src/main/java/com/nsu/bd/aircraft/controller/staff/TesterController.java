package com.nsu.bd.aircraft.controller.staff;

import com.nsu.bd.aircraft.service.staff.TesterService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/aircraft/staff/testers")
public class TesterController extends StaffController {
    private final TesterService testerService;

    public TesterController(@Autowired TesterService testerService) {
        super(testerService);
        this.testerService = testerService;
    }
}
