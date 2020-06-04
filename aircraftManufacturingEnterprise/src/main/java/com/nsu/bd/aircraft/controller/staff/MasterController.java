package com.nsu.bd.aircraft.controller.staff;

import com.nsu.bd.aircraft.api.GeneralResponse;
import com.nsu.bd.aircraft.api.dto.company.SiteDto;
import com.nsu.bd.aircraft.api.dto.staff.EmployeeDto;
import com.nsu.bd.aircraft.service.staff.MasterService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/aircraft/staff/master")
public class MasterController extends StaffController {
    private final MasterService masterService;

    public MasterController(@Autowired MasterService masterService) {
        super(masterService);
        this.masterService = masterService;
    }

    @PostMapping("/get-by-site")
    public GeneralResponse<List<EmployeeDto>> getBySite(
            @RequestBody SiteDto siteDto) {
        return new GeneralResponse<>(masterService.getBySite(siteDto));
    }
}
