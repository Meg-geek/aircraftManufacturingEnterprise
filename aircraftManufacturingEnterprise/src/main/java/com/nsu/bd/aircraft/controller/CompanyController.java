package com.nsu.bd.aircraft.controller;

import com.nsu.bd.aircraft.model.company.Company;
import com.nsu.bd.aircraft.service.company.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aircraft/company")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping("/add")
    public ResponseEntity addCompany(@RequestBody Company company){
        Company addedCompany = companyService.addCompanyIfNotExist(company);
        if(addedCompany != null){
            return ResponseEntity.ok().body(addedCompany);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
