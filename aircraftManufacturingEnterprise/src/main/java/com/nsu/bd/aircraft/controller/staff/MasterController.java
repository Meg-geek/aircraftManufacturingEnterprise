package com.nsu.bd.aircraft.controller.staff;

import com.nsu.bd.aircraft.service.staff.MasterService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/aircraft/staff/master")
public class MasterController extends StaffController {
    private final MasterService masterService;

    public MasterController(@Autowired MasterService masterService) {
        super(masterService);
        this.masterService = masterService;
    }
}
