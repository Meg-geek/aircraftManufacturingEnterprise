package com.nsu.bd.aircraft.controller.staff;

import com.nsu.bd.aircraft.service.staff.SiteManagerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/aircraft/staff/site-managers")
public class SiteManagerController extends StaffController {
    private final SiteManagerService siteManagerService;

    public SiteManagerController(@Autowired SiteManagerService siteManagerService) {
        super(siteManagerService);
        this.siteManagerService = siteManagerService;
    }
}
