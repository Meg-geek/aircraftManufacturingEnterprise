package com.nsu.bd.aircraft.controller.company;

import com.nsu.bd.aircraft.api.ErrorCause;
import com.nsu.bd.aircraft.api.GeneralResponse;
import com.nsu.bd.aircraft.api.Status;
import com.nsu.bd.aircraft.api.dto.company.GuildDto;
import com.nsu.bd.aircraft.api.dto.staff.EmployeeDto;
import com.nsu.bd.aircraft.service.company.GuildService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/aircraft/guild")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GuildController {
    private final static String LOG_INFO = "GuildController:: ";
    private final GuildService guildService;

    @PostMapping("/add")
    public GeneralResponse<GuildDto> addGuild(@RequestBody GuildDto guildDto) {
        log.info(LOG_INFO + "addGuild request");
        boolean isGuildAdded = guildService.addGuild(guildDto);
        if (isGuildAdded) {
            return new GeneralResponse<>(Status.OK);
        }
        return new GeneralResponse<>(Status.ERROR, ErrorCause.ALREADY_EXITS);
    }

    @GetMapping("/get-all")
    public GeneralResponse<List<GuildDto>> getAllGuilds() {
        log.info(LOG_INFO + "get all guilds request");
        return new GeneralResponse<>(guildService.getAllGuilds());
    }

    @GetMapping("/get-by-company")
    public GeneralResponse<List<GuildDto>> getCompanyGuilds(@RequestParam("companyId") int companyId) {
        log.info(LOG_INFO + "get company guilds request");
        return new GeneralResponse<>(guildService.findByCompanyId(companyId));
    }

    @DeleteMapping("/delete-by-id")
    public void deleteById(@RequestParam("guildId") int guildId) {
        guildService.deleteById(guildId);
    }

    @GetMapping("/get-guild-manager-by-guild-id")
    public GeneralResponse<EmployeeDto> getGuildManagerByGuildId(
            @RequestParam("guildId") int guildId) {
        return new GeneralResponse<>(new EmployeeDto());
    }
}
