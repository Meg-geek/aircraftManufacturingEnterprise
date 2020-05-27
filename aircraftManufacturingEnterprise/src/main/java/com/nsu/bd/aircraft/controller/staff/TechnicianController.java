package com.nsu.bd.aircraft.controller.staff;

import com.nsu.bd.aircraft.service.staff.TechnicianService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/aircraft/staff/technicians")
public class TechnicianController extends StaffController {
    private final TechnicianService technicianService;

    public TechnicianController(@Autowired TechnicianService technicianService) {
        super(technicianService);
        this.technicianService = technicianService;
    }
}
