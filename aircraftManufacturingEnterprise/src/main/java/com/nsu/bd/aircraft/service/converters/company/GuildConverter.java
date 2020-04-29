package com.nsu.bd.aircraft.service.converters.company;

import com.nsu.bd.aircraft.api.dto.company.GuildDto;
import com.nsu.bd.aircraft.model.company.Guild;
import org.springframework.stereotype.Component;

@Component
public class GuildConverter {
    private static final int EMPTY_ID = 0;

    public Guild getGuild(GuildDto guildDto) {
        return new Guild(guildDto.getGuildName(), guildDto.getCompany());
    }

    public GuildDto getGuildDto(Guild guild) {
        return new GuildDto(guild.getId(),
                guild.getGuildName(),
                guild.getCompany(),
                guild.getGuildManager() != null ? guild.getGuildManager().getId() : EMPTY_ID);

    }
}
