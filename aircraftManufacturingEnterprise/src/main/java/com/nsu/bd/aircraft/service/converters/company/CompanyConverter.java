package com.nsu.bd.aircraft.service.converters.company;

import com.nsu.bd.aircraft.api.dto.company.CompanyDto;
import com.nsu.bd.aircraft.model.company.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyConverter {
    public Company getCompany(CompanyDto companyDto) {
        if (companyDto == null) {
            return null;
        }
        return new Company(companyDto.getName());
    }

    public CompanyDto getCompanyDto(Company company) {
        if (company == null) {
            return null;
        }
        return new CompanyDto(company.getId(), company.getName());
    }
}
