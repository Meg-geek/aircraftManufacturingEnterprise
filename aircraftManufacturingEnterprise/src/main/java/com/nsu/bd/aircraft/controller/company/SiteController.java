package com.nsu.bd.aircraft.controller.company;

import com.nsu.bd.aircraft.api.GeneralResponse;
import com.nsu.bd.aircraft.api.dto.company.GuildDto;
import com.nsu.bd.aircraft.api.dto.company.SiteDto;
import com.nsu.bd.aircraft.api.dto.staff.EmployeeDto;
import com.nsu.bd.aircraft.service.company.SiteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/aircraft/site")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SiteController {
    private final SiteService siteService;

    @PostMapping("/add")
    public GeneralResponse<?> addSite(@RequestBody SiteDto site) {
        siteService.addSite(site);
        return GeneralResponse.ok();
    }

    @GetMapping("/get-all")
    public GeneralResponse<List<SiteDto>> getAllSites() {
        return new GeneralResponse<>(siteService.getAllSites());
    }

    @DeleteMapping("/delete-by-id")
    public void deleteById(@RequestParam("siteId") int siteId) {
        siteService.deleteById(siteId);
    }

    @PutMapping("/update")
    public GeneralResponse<SiteDto> update(@RequestBody SiteDto siteDto) {
        return new GeneralResponse<>(siteService.updateSite(siteDto));
    }

    @GetMapping("/get-managers")
    public GeneralResponse<List<EmployeeDto>> getSiteManagers() {
        return new GeneralResponse<>(siteService.getSiteManagers());
    }

    @PutMapping("/update-manager")
    public GeneralResponse<?> updateSiteManager(@RequestParam("siteId") int siteId,
                                                @RequestParam("managerId") int newManagerId) {
        log.info("update site with id " + siteId + " add manager with id " + newManagerId);
        siteService.updateSiteManager(siteId, newManagerId);
        return GeneralResponse.ok();
    }

    @GetMapping("/get-site-manager-by-site-id")
    public GeneralResponse<EmployeeDto> getSiteManagerBySiteId(
            @RequestParam("siteId") int siteId) {
        log.info("Get request to get site manager for " + siteId + " site");
        return new GeneralResponse<>(siteService.getSiteManagerBySiteId(siteId));
    }

    @PostMapping("/get-by-guild")
    public GeneralResponse<List<SiteDto>> getSitesByGuild(@RequestBody GuildDto guildDto) {
        return new GeneralResponse<>(siteService.getByGuild(guildDto));
    }

    @GetMapping("/get-by-company-id")
    public GeneralResponse<List<SiteDto>> getSitesByCompanyId(
            @RequestParam("companyId") int companyId) {
        return new GeneralResponse<>(siteService.getByCompanyId(companyId));
    }
}
