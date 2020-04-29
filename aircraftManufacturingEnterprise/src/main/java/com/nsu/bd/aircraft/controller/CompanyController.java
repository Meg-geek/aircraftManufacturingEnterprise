package com.nsu.bd.aircraft.controller;

import com.nsu.bd.aircraft.api.ErrorCause;
import com.nsu.bd.aircraft.api.GeneralResponse;
import com.nsu.bd.aircraft.api.Status;
import com.nsu.bd.aircraft.api.dto.company.CompanyDto;
import com.nsu.bd.aircraft.model.company.Guild;
import com.nsu.bd.aircraft.service.company.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aircraft/company")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping("/add")
    public GeneralResponse<?> addCompany(@RequestBody CompanyDto companyDto) {
        boolean isCompanyAdded = (companyService.addCompany(companyDto) != null);
        if (isCompanyAdded) {
            return new GeneralResponse<>(Status.OK);
        }
        return new GeneralResponse<>(Status.ERROR, ErrorCause.ALREADY_EXITS);
    }

    @GetMapping("/get-all")
    public GeneralResponse<List<CompanyDto>> getAllCompanies() {
        return new GeneralResponse<>(companyService.getAllCompanies());
    }

    @GetMapping("/get-guilds")
    public GeneralResponse<List<Guild>> getGuildsByCompanyName(
            @RequestParam("companyName") String companyName) {
        return new GeneralResponse<>(companyService
                .getGuildsByCompanyName(companyName));
    }

    @DeleteMapping
    public void deleteCompanyByName(
            @RequestParam("companyName") String companyName) {
        companyService.deleteCompanyByName(companyName);
    }
}
