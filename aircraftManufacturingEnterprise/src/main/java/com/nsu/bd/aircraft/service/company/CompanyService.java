package com.nsu.bd.aircraft.service.company;

import com.nsu.bd.aircraft.dao.company.CompanyDao;
import com.nsu.bd.aircraft.model.company.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CompanyService {
    private final CompanyDao companyDao;
    private final GuildService guildService;

    public void addCompany(Company company){
        if(company == null){
            return;
        }
        companyDao.addCompany(company);
        if(company.getGuilds() == null){
            return;
        }
        company.getGuilds()
                .forEach(guild -> guild.setCompanyId(company.getId()));
        guildService.addGuilds(company.getGuilds());
    }
}
