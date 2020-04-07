package com.nsu.bd.aircraft.controller;

import com.nsu.bd.aircraft.model.company.Guild;
import com.nsu.bd.aircraft.service.company.GuildService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aircraft/guild")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GuildController {
    private final GuildService guildService;

    @PostMapping("/add")
    public void addGuild(@RequestBody Guild guild){
        guildService.addGuild(guild);
    }
}
