package com.nsu.bd.aircraft.service.company;

import com.nsu.bd.aircraft.dao.company.GuildDao;
import com.nsu.bd.aircraft.model.company.Company;
import com.nsu.bd.aircraft.model.company.Guild;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GuildService {
    private final GuildDao guildDao;

    public void addGuild(Guild guild){
        guildDao.save(guild);
    }

    public void addGuilds(List<Guild> guilds){

    }
}
