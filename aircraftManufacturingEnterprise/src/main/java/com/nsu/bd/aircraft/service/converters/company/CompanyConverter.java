package com.nsu.bd.aircraft.service.converters.company;

import com.nsu.bd.aircraft.api.dto.company.CompanyDto;
import com.nsu.bd.aircraft.model.company.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyConverter {
    public Company getCompany(CompanyDto companyDto) {
        return new Company(companyDto.getName());
    }

    public CompanyDto getCompanyDto(Company company) {
        return new CompanyDto(company.getId(), company.getName());
    }
}
