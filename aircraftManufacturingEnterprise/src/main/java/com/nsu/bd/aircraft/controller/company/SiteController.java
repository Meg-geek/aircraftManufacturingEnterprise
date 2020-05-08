package com.nsu.bd.aircraft.controller.company;

import com.nsu.bd.aircraft.model.company.Site;
import com.nsu.bd.aircraft.service.company.SiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aircraft/site")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SiteController {
    private final SiteService siteService;

    @RequestMapping("/add")
    public void addSite(@RequestBody Site site) {
        siteService.addSite(site);
    }
}
