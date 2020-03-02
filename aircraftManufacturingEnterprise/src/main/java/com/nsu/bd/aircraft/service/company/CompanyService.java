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

    public void addCompany(Company company) {
        companyDao.save(company);
    }

    public Company findCompanyByName(String name) {
        return companyDao.findByName(name);
    }
}
