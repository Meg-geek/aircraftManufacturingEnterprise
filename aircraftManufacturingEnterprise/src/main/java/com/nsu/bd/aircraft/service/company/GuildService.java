package com.nsu.bd.aircraft.service.company;

import com.nsu.bd.aircraft.api.dto.company.GuildDto;
import com.nsu.bd.aircraft.dao.company.GuildDao;
import com.nsu.bd.aircraft.model.company.Guild;
import com.nsu.bd.aircraft.service.converters.company.GuildConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
                .getCompanyByName(guildDto.getCompany()));
        guildDao.save(guild);
        return true;
    }

    public Guild addGuild(Guild guild) {
        Guild foundGuild = guildDao.findByGuildName(guild.getGuildName());
        if (foundGuild != null) {
            return foundGuild;
        }
        return guildDao.save(guild);
    }

    public List<GuildDto> findByCompanyId(int companyId) {
        return guildConverter
                .getGuildDtosList(guildDao.findByCompanyId(companyId));
    }

    public List<GuildDto> getAllGuilds() {
        return guildConverter
                .getGuildDtosList(guildDao.findAll());
    }

    @Transactional
    public void deleteById(int id) {
        guildDao.deleteById(id);
    }
}
