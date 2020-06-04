package com.nsu.bd.aircraft.service.product;

import com.nsu.bd.aircraft.api.dto.product.ProductDto;
import com.nsu.bd.aircraft.dao.product.HelicopterDao;
import com.nsu.bd.aircraft.model.product.Helicopter;
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
public class HelicopterService {
    private final HelicopterDao helicopterDao;
    private final ProductConverter productConverter;
    private final GuildService guildService;

    public List<ProductDto> getAllHelicopters() {
        return productConverter
                .getProductDtos(helicopterDao.findAll());
    }

    @Transactional
    public ProductDto changeHelicopter(ProductDto productDto) {
        Helicopter helicopter = (Helicopter) productConverter.getProduct(productDto);
        helicopter.setGuild(guildService.addGuild(helicopter.getGuild()));
        return productConverter.getProductDto(helicopterDao.save(helicopter));
    }

    public List<String> getTypesByCompanyId(int companyId) {
        return helicopterDao.findTypesByCompanyId(companyId);
    }

    public List<String> getTypesByGuildId(int guildId) {
        return helicopterDao.findTypesByGuildId(guildId);
    }

    public List<ProductDto> getProductsByDateIntervalAndCompany(int companyId,
                                                                long beginDate,
                                                                long endDate) {
        if (endDate == 0) {
            return productConverter
                    .getProductDtos(helicopterDao.findByDateIntervalAndCompany(companyId,
                            new Date(beginDate), new Date(System.currentTimeMillis())));
        }
        return productConverter
                .getProductDtos(helicopterDao
                        .findByDateIntervalAndCompany(companyId,
                                new Date(beginDate),
                                new Date(endDate)));
    }

    public List<ProductDto> getProductsByDateIntervalAndGuild(int guildId,
                                                              long beginDate,
                                                              long endDate) {
        if (endDate == 0) {
            return productConverter
                    .getProductDtos(helicopterDao.findByDateIntervalAndGuild(guildId,
                            new Date(beginDate), new Date(System.currentTimeMillis())));
        }
        return productConverter
                .getProductDtos(helicopterDao
                        .findByDateIntervalAndGuild(guildId,
                                new Date(beginDate),
                                new Date(endDate)));
    }

    public List<ProductDto> getProductsByDateIntervalAndSite(int siteId,
                                                             long beginDate,
                                                             long endDate) {
        if (endDate == 0) {
            return productConverter
                    .getProductDtos(helicopterDao.findByDateIntervalAndSite(siteId,
                            new Date(beginDate), new Date(System.currentTimeMillis())));
        }
        return productConverter
                .getProductDtos(helicopterDao
                        .findByDateIntervalAndSite(siteId,
                                new Date(beginDate),
                                new Date(endDate)));
    }

    public List<ProductDto> findNowBuildingByCompany(int companyId) {
        return productConverter.getProductDtos(
                helicopterDao.findNowBuildingByCompany(companyId));
    }

    public List<ProductDto> findNowBuildingByGuild(int guildId) {
        return productConverter.getProductDtos(
                helicopterDao.findNowBuildingByGuild(guildId));
    }

    public List<ProductDto> findNowBuildingBySite(int siteId) {
        return productConverter.getProductDtos(
                helicopterDao.findNowBuildingBySite(siteId));
    }
}
