package com.nsu.bd.aircraft.service.product;

import com.nsu.bd.aircraft.api.dto.product.ProductDto;
import com.nsu.bd.aircraft.dao.product.PlaneDao;
import com.nsu.bd.aircraft.model.product.Plane;
import com.nsu.bd.aircraft.service.company.GuildService;
import com.nsu.bd.aircraft.service.converters.product.ProductConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PlaneService {
    private final PlaneDao planeDao;
    private final ProductConverter productConverter;
    private final GuildService guildService;

    public List<ProductDto> getAllPlanes() {
        return productConverter.getProductDtos(planeDao.findAll());
    }

    @Transactional
    public ProductDto changePlane(ProductDto productDto) {
        Plane plane = productConverter.getPlane(productDto);
        plane.setGuild(guildService.addGuild(plane.getGuild()));
        return productConverter.getProductDto(planeDao.save(plane));
    }

    public List<String> getTypesByCompanyId(int companyId) {
        return planeDao.findTypesByCompanyId(companyId);
    }

    public List<String> getTypesByGuildId(int guildId) {
        return planeDao.findTypesByGuildId(guildId);
    }

    public List<ProductDto> getProductsByDateIntervalAndCompany(int companyId,
                                                                long beginDate,
                                                                long endDate) {
        if (endDate == 0) {
            return productConverter
                    .getProductDtos(planeDao.findByDateIntervalAndCompany(companyId,
                            new Date(beginDate), new Date(System.currentTimeMillis())));
        }
        return productConverter
                .getProductDtos(planeDao
                        .findByDateIntervalAndCompany(companyId,
                                new Date(beginDate),
                                new Date(endDate)));
    }

    public List<ProductDto> getProductsByDateIntervalAndSite(int siteId,
                                                             long beginDate,
                                                             long endDate) {
        if (endDate == 0) {
            return productConverter
                    .getProductDtos(planeDao.findByDateIntervalAndSite(siteId,
                            new Date(beginDate), new Date(System.currentTimeMillis())));
        }
        return productConverter
                .getProductDtos(planeDao
                        .findByDateIntervalAndSite(siteId,
                                new Date(beginDate),
                                new Date(endDate)));
    }

    public List<ProductDto> getProductsByDateIntervalAndGuild(int guildId,
                                                              long beginDate,
                                                              long endDate) {
        if (endDate == 0) {
            return productConverter
                    .getProductDtos(planeDao.findByDateIntervalAndGuild(guildId,
                            new Date(beginDate), new Date(System.currentTimeMillis())));
        }
        return productConverter
                .getProductDtos(planeDao
                        .findByDateIntervalAndGuild(guildId,
                                new Date(beginDate),
                                new Date(endDate)));
    }

    public List<ProductDto> findNowBuildingByCompany(int companyId) {
        return productConverter.getProductDtos(
                planeDao.findNowBuildingByCompany(companyId));
    }

    public List<ProductDto> findNowBuildingByGuild(int guildId) {
        return productConverter.getProductDtos(
                planeDao.findNowBuildingByGuild(guildId));
    }

    public List<ProductDto> findNowBuildingBySite(int siteId) {
        return productConverter.getProductDtos(
                planeDao.findNowBuildingBySite(siteId));
    }

    public List<ProductDto> findByDateIntervalAndRange(int rangeId,
                                                       long beginDate,
                                                       long endDate) {
        if (endDate == 0) {
            return productConverter
                    .getProductDtos(planeDao.findByDateIntervalAndRange(rangeId,
                            new Date(beginDate), new Date(System.currentTimeMillis())));
        }
        return productConverter
                .getProductDtos(planeDao
                        .findByDateIntervalAndRange(rangeId,
                                new Date(beginDate),
                                new Date(endDate)));
    }

    @Transactional
    public void add(ProductDto productDto) {
        Plane plane = productConverter.getPlane(productDto);
        planeDao.save(plane);
    }
}
