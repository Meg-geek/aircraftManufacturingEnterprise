package com.nsu.bd.aircraft.service.company;

import com.nsu.bd.aircraft.api.dto.company.CompanyDto;
import com.nsu.bd.aircraft.api.dto.company.GuildDto;
import com.nsu.bd.aircraft.dao.company.GuildDao;
import com.nsu.bd.aircraft.model.company.Guild;
import com.nsu.bd.aircraft.service.converters.company.GuildConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GuildService {
    private final GuildDao guildDao;
    private final GuildConverter guildConverter;
    private final CompanyService companyService;

    public boolean addGuild(GuildDto guildDto) {
        Guild guild = guildDao.findByGuildName(guildDto.getGuildName());
        if (guild != null) {
            return false;
        }
        guild = guildConverter.getGuild(guildDto);
        guild.setCompany(companyService
                .addCompany(guildDto.getCompany()));
        guildDao.save(guild);
        return true;
    }

    public List<GuildDto> findByCompany(CompanyDto company) {
        return makeGuildsResponse(guildDao.findByCompanyId(company.getId()));
    }

    public List<GuildDto> getAllGuilds() {
        return makeGuildsResponse(guildDao.findAll());
    }

    private List<GuildDto> makeGuildsResponse(List<Guild> guilds) {
        if (guilds == null) {
            return emptyList();
        }
        return guildConverter.getGuildDtosList(guilds);
    }

}
