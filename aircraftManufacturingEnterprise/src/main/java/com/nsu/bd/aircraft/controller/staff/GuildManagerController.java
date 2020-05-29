package com.nsu.bd.aircraft.controller.staff;

import com.nsu.bd.aircraft.service.staff.GuildManagerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/aircraft/staff/guild-managers")
public class GuildManagerController extends StaffController {
    private final GuildManagerService guildManagerService;

    public GuildManagerController(@Autowired GuildManagerService guildManagerService) {
        super(guildManagerService);
        this.guildManagerService = guildManagerService;
    }
}
