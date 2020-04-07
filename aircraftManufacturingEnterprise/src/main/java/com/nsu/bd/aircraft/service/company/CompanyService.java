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

    public Company findCompanyByName(String name) {
        return companyDao.findByName(name);
    }

    public Company addCompanyIfNotExist(Company company){
        if(company == null || company.getName() == null){
            return null;
        }
        Company foundCompany = companyDao.findByName(company.getName());
        if(foundCompany != null){
            return foundCompany;
        }
        return companyDao.save(company);
    }
}
