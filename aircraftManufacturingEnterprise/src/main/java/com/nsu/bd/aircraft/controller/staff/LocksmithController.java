package com.nsu.bd.aircraft.controller.staff;

import com.nsu.bd.aircraft.service.staff.LocksmithService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/aircraft/staff/locksmiths")
public class LocksmithController extends StaffController {
    private final LocksmithService locksmithService;

    public LocksmithController(@Autowired LocksmithService locksmithService) {
        super(locksmithService);
        this.locksmithService = locksmithService;
    }
}
