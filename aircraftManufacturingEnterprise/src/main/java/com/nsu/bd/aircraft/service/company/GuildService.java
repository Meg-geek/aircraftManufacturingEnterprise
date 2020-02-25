package com.nsu.bd.aircraft.service.company;

import com.nsu.bd.aircraft.dao.company.GuildDao;
import com.nsu.bd.aircraft.model.company.Guild;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GuildService {
    private final GuildDao guildDao;
    private final SiteService siteService;

    public void addGuilds(List<Guild> guilds){
        if(guilds == null){
            return;
        }
        for(Guild guild : guilds){
            guildDao.addGuild(guild);
            addSites(guild);
        }
    }

    private void addSites(Guild guild){
        if(guild == null || guild.getSites() == null){
            return;
        }
        guild.getSites().forEach(site -> site.setGuildId(guild.getId()));
        siteService.addSites(guild.getSites());
    }
}
