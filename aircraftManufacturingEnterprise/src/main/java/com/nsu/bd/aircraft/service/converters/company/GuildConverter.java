package com.nsu.bd.aircraft.service.converters.company;

import com.nsu.bd.aircraft.api.dto.company.GuildDto;
import com.nsu.bd.aircraft.model.company.Guild;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GuildConverter {
    private static final int EMPTY_ID = 0;
    private final CompanyConverter companyConverter;

    public Guild getGuild(GuildDto guildDto) {
        return new Guild(guildDto.getGuildName());
    }

    public GuildDto getGuildDto(Guild guild) {
        return new GuildDto(guild.getId(),
                guild.getGuildName(),
                companyConverter.getCompanyDto(guild.getCompany()),
                guild.getGuildManager() != null ? guild.getGuildManager().getId() : EMPTY_ID);

    }

    public List<GuildDto> getGuildDtosList(List<Guild> guilds) {
        List<GuildDto> guildDtos = new ArrayList<>();
        guilds.forEach(guild -> guildDtos.add(getGuildDto(guild)));
        return guildDtos;
    }
}
