package com.nsu.bd.aircraft.controller.staff;

import com.nsu.bd.aircraft.api.dto.staff.GuildManagerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/aircraft/staff/guild-manager")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GuildManagerController {
    @GetMapping("/test")
    public GuildManagerDto test() {
        return new GuildManagerDto(1, "name", null);
    }

}
