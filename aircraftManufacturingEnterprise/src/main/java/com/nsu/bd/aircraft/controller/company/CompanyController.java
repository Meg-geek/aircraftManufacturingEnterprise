package com.nsu.bd.aircraft.controller.company;

import com.nsu.bd.aircraft.api.ErrorCause;
import com.nsu.bd.aircraft.api.GeneralResponse;
import com.nsu.bd.aircraft.api.Status;
import com.nsu.bd.aircraft.api.dto.company.CompanyDto;
import com.nsu.bd.aircraft.service.company.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/aircraft/company")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CompanyController {
    private final static String LOG_INFO = "CompanyController:: ";
    private final CompanyService companyService;

    @PostMapping("/add")
    public GeneralResponse<CompanyDto> addCompany(@RequestBody CompanyDto companyDto) {
        boolean isCompanyAdded = (companyService.addCompany(companyDto) != null);
        if (isCompanyAdded) {
            log.info(LOG_INFO + "Added company");
            return new GeneralResponse<>(Status.OK);
        }
        log.info(LOG_INFO + "Error happened while adding company");
        return new GeneralResponse<>(Status.ERROR, ErrorCause.ALREADY_EXITS);
    }

    @GetMapping("/get-all")
    public GeneralResponse<List<CompanyDto>> getAllCompanies() {
        log.info(LOG_INFO + "Get request to get all companies");
        return new GeneralResponse<>(companyService.getAllCompanies());
    }

    @DeleteMapping("/delete-by-name")
    public GeneralResponse<?> deleteCompanyByName(
            @RequestParam("companyName") String companyName) {
        log.info(LOG_INFO + "Get request to delete company " + companyName);
        companyService.deleteCompanyByName(companyName);
        return new GeneralResponse<>(Status.OK);
    }

    @PutMapping("/change-name")
    public GeneralResponse<?> changeCompanyName(@RequestBody CompanyDto company,
                                                @RequestParam("newName") String newName) {
        log.info(LOG_INFO + "request to change company name");
        if (companyService.changeCompanyName(company, newName)) {
            return new GeneralResponse<>(Status.OK);
        }
        return new GeneralResponse<>(Status.ERROR, ErrorCause.DOESNT_EXIST);
    }
}
