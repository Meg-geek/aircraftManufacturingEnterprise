package com.nsu.bd.aircraft.service.company;

import com.nsu.bd.aircraft.api.dto.company.SiteDto;
import com.nsu.bd.aircraft.api.dto.staff.EmployeeDto;
import com.nsu.bd.aircraft.dao.company.SiteDao;
import com.nsu.bd.aircraft.service.converters.company.SiteConverter;
import com.nsu.bd.aircraft.service.staff.EngineeringStaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SiteService {
    private final SiteDao siteDao;
    private final SiteConverter siteConverter;
    private final EngineeringStaffService engineeringStaffService;

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
}
