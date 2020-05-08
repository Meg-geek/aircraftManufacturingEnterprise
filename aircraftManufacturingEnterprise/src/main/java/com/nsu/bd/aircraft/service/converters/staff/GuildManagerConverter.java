package com.nsu.bd.aircraft.service.converters.staff;

import com.nsu.bd.aircraft.api.dto.staff.GuildManagerDto;
import com.nsu.bd.aircraft.model.staff.GuildManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GuildManagerConverter {
    public GuildManagerDto getGuildManagerDto(GuildManager guildManager) {
        if (guildManager == null) {
            return null;
        }
        return new GuildManagerDto(guildManager.getId(),
                guildManager.getName(),
                guildManager.getSurname());
    }

    public GuildManager getGuildManager(GuildManagerDto guildManagerDto) {
        if (guildManagerDto == null) {
            return null;
        }
        return new GuildManager(guildManagerDto.getId(),
                guildManagerDto.getName(),
                guildManagerDto.getSurname());
    }
}
