package com.nsu.bd.aircraft.service.company;

import com.nsu.bd.aircraft.dao.company.SiteDao;
import com.nsu.bd.aircraft.model.company.Site;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SiteService {
    private final SiteDao siteDao;

    public void addSite(Site site) {
        if(isSiteIncorrectInsert(site)){
            return;
        }
        siteDao.save(site);
    }

    private boolean isSiteIncorrectInsert(Site site){
        return site == null || site.getWorkType() == null;
    }
}
