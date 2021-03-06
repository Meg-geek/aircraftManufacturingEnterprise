package com.nsu.bd.aircraft.service.company;

import com.nsu.bd.aircraft.api.dto.company.CompanyDto;
import com.nsu.bd.aircraft.dao.company.CompanyDao;
import com.nsu.bd.aircraft.model.company.Company;
import com.nsu.bd.aircraft.service.converters.company.CompanyConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CompanyService {
    private final CompanyConverter companyConverter;
    private final CompanyDao companyDao;

    public Company findCompanyByName(String name) {
        return companyDao.findByName(name);
    }

    public Company addCompany(CompanyDto companyDto) {
        Company foundCompany = companyDao.findByName(companyDto.getName());
        if (foundCompany != null) {
            return null;
        }
        return companyDao.save(companyConverter.getCompany(companyDto));
    }

    public Company getCompanyByName(CompanyDto companyDto) {
        Company foundCompany = companyDao.findByName(companyDto.getName());
        if (foundCompany != null) {
            return foundCompany;
        }
        return companyDao.save(companyConverter.getCompany(companyDto));
    }

    public List<CompanyDto> getAllCompanies() {
        List<Company> companies = companyDao.findAll();
        if (companies == null) {
            return emptyList();
        }
        List<CompanyDto> companyDtos = new ArrayList<>();
        companies
                .forEach(company ->
                        companyDtos.add(companyConverter.getCompanyDto(company)));
        return companyDtos;
    }

    @Transactional
    public boolean changeCompanyName(CompanyDto companyDto, String newName) {
        Company foundCompany = companyDao.findByName(companyDto.getName());
        if (foundCompany == null) {
            return false;
        }
        companyDao.updateCompanyName(foundCompany.getId(), newName);
        return true;
    }

    @Transactional
    public void deleteCompanyByName(String name) {
        companyDao.deleteByName(name);
    }
}
