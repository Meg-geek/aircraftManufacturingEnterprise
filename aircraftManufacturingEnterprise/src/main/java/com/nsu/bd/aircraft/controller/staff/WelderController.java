package com.nsu.bd.aircraft.controller.staff;

import com.nsu.bd.aircraft.service.staff.WelderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/aircraft/staff/welders")
public class WelderController extends StaffController {
    private final WelderService welderService;

    public WelderController(@Autowired WelderService welderService) {
        super(welderService);
        this.welderService = welderService;
    }
}
