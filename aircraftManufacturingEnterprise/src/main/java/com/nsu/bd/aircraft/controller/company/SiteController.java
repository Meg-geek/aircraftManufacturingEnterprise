package com.nsu.bd.aircraft.controller.company;

import com.nsu.bd.aircraft.api.GeneralResponse;
import com.nsu.bd.aircraft.api.dto.company.SiteDto;
import com.nsu.bd.aircraft.service.company.SiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aircraft/site")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SiteController {
    private final SiteService siteService;

    @RequestMapping("/add")
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
}
