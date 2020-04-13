package com.nsu.bd.aircraft.service.company;

import com.nsu.bd.aircraft.dao.company.CompanyDao;
import com.nsu.bd.aircraft.model.company.Company;
import com.nsu.bd.aircraft.model.company.Guild;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CompanyService {
    private final CompanyDao companyDao;
    private final GuildService guildService;

    public Company findCompanyByName(String name) {
        return companyDao.findByName(name);
    }

    public Company addCompany(Company company){
        Company foundCompany = companyDao.findByName(company.getName());
        if(foundCompany != null){
            return foundCompany;
        }
        guildService.addGuilds(company.getGuilds());
        return companyDao.save(company);
    }

    public List<Company> getAllCompanies(){
        return companyDao.findAll();
    }

    public List<Guild> getGuildsByCompanyName(String companyName){
        Company company = companyDao.findByName(companyName);
        if(company == null){
            return emptyList();
        }
        return guildService
                .findByCompanyId(company.getId());
    }

    @Transactional
    public void deleteCompanyByName(String name){
        companyDao.deleteByName(name);
    }
}
