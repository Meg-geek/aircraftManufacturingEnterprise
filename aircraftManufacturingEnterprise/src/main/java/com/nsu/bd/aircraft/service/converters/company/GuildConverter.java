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
    private final CompanyConverter companyConverter;

    public Guild getGuild(GuildDto guildDto) {
        if (guildDto == null) {
            return null;
        }
        return new Guild(guildDto.getId(),
                guildDto.getGuildName(),
                companyConverter.getCompany(guildDto.getCompany()));
    }

    public GuildDto getGuildDto(Guild guild) {
        if (guild == null) {
            return null;
        }
        return new GuildDto(guild.getId(),
                guild.getGuildName(),
                companyConverter.getCompanyDto(guild.getCompany()));
    }


    public List<GuildDto> getGuildDtosList(List<Guild> guilds) {
        List<GuildDto> guildDtos = new ArrayList<>();
        guilds.forEach(guild -> guildDtos.add(getGuildDto(guild)));
        return guildDtos;
    }
}
