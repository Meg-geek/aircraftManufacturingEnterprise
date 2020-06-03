package com.nsu.bd.aircraft.controller.staff;

import com.nsu.bd.aircraft.api.GeneralResponse;
import com.nsu.bd.aircraft.api.dto.staff.EmployeeDto;
import com.nsu.bd.aircraft.service.staff.EngineeringStaffService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/aircraft/staff/engineering-staff")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EngineeringStaffController {
    private final EngineeringStaffService engineeringStaffService;

    @GetMapping("/get-free-managers-for-guild")
    public GeneralResponse<List<EmployeeDto>> getFreeStaff(@RequestParam("guildId") int guildId) {
        return new GeneralResponse<>(engineeringStaffService.getFreeStaffForGuildManager(guildId));
    }

    @GetMapping("/get-free-managers-for-site")
    public GeneralResponse<List<EmployeeDto>> getFreeStaffForSiteManagers() {
        log.info("get request to get free managers for site");
        return new GeneralResponse<>(engineeringStaffService.getFreeStaff());
    }
}
