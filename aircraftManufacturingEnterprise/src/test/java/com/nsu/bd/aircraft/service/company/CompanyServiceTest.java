package com.nsu.bd.aircraft.service.company;

import com.nsu.bd.aircraft.SpringAirManufacturingApplication;
import com.nsu.bd.aircraft.model.company.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringAirManufacturingApplication.class)
public class CompanyServiceTest {
    @Autowired
    private CompanyService companyService;

    @Test
    public void addCompany() {
        String name = "Тестовое предприятие";
        Company company = new Company(name);
        companyService.addCompany(company);
        assertEquals(company.getId(), companyService.findCompanyByName(name).getId());
    }
}