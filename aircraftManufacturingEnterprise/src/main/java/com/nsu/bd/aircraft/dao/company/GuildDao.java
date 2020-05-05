package com.nsu.bd.aircraft.dao.company;

import com.nsu.bd.aircraft.model.company.Guild;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GuildDao extends CrudRepository<Guild, Integer> {
    List<Guild> findByCompanyId(int companyId);

    Guild findByGuildName(String guildName);

    @Override
    List<Guild> findAll();
}
