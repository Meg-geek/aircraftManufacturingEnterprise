package com.nsu.bd.aircraft.service.company;

import com.nsu.bd.aircraft.dao.company.SiteDao;
import com.nsu.bd.aircraft.model.company.Site;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SiteService {
    private final SiteDao siteDao;

    public void addSites(List<Site> sites){
        if(sites == null){
            return;
        }
        sites.forEach(siteDao::addSite);
    }
}
