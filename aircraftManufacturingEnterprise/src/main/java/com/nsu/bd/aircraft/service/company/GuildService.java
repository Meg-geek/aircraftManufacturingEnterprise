package com.nsu.bd.aircraft.service.company;

import com.nsu.bd.aircraft.dao.company.GuildDao;
import com.nsu.bd.aircraft.model.company.Company;
import com.nsu.bd.aircraft.model.company.Guild;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GuildService {
    private final CompanyService companyService;
    private final GuildDao guildDao;

    public void addGuild(Guild guild){
        Company company = companyService.addCompanyIfNotExist(guild.getCompany());
        guild.setCompany(company);
        guildDao.save(guild);
    }
}
