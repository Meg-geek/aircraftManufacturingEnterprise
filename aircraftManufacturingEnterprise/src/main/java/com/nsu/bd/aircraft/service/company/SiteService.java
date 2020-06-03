package com.nsu.bd.aircraft.service.company;

import com.nsu.bd.aircraft.api.dto.company.GuildDto;
import com.nsu.bd.aircraft.api.dto.company.SiteDto;
import com.nsu.bd.aircraft.api.dto.staff.EmployeeDto;
import com.nsu.bd.aircraft.dao.company.SiteDao;
import com.nsu.bd.aircraft.model.company.Site;
import com.nsu.bd.aircraft.service.converters.company.GuildConverter;
import com.nsu.bd.aircraft.service.converters.company.SiteConverter;
import com.nsu.bd.aircraft.service.staff.EngineeringStaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SiteService {
    private final SiteDao siteDao;
    private final SiteConverter siteConverter;
    private final EngineeringStaffService engineeringStaffService;
    private final GuildConverter guildConverter;

    @Transactional
    public void addSite(SiteDto siteDto) {
        siteDao.save(siteConverter.getSite(siteDto));
    }

    public List<SiteDto> getAllSites() {
        return siteConverter.getSiteDtos(siteDao.findAll());
    }

    @Transactional
    public void deleteById(int id) {
        siteDao.deleteById(id);
    }

    public List<EmployeeDto> getSiteManagers() {
        return engineeringStaffService.getSiteManagers();
    }

    public SiteDto updateSite(SiteDto siteDto) {
        return siteConverter.getSiteDto(
                siteDao
                        .save(siteConverter.getSite(siteDto)));
    }

    @Transactional
    public void updateSiteManager(int siteId, int newManagerId) {
        siteDao.updateSiteManager(siteId, newManagerId);
    }

    public EmployeeDto getSiteManagerBySiteId(int siteId) {
        Optional<Integer> siteManagerId = siteDao.findSiteManagerIdBySiteId(siteId);
        if (siteManagerId.isEmpty()) {
            return new EmployeeDto();
        }
        return engineeringStaffService.getById(siteManagerId.get());
    }

    public List<SiteDto> getByGuild(GuildDto guildDto) {
        List<Site> sites = siteDao.findByGuild(guildConverter.getGuild(guildDto));
        return siteConverter.getSiteDtos(sites);
    }
}
