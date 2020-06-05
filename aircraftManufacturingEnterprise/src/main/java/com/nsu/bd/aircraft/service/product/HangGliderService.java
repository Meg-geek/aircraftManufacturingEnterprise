package com.nsu.bd.aircraft.service.product;

import com.nsu.bd.aircraft.api.dto.product.ProductDto;
import com.nsu.bd.aircraft.dao.product.HangGliderDao;
import com.nsu.bd.aircraft.model.product.HangGlider;
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
public class HangGliderService {
    private final HangGliderDao hangGliderDao;
    private final ProductConverter productConverter;
    private final GuildService guildService;

    public List<ProductDto> getAllHangGliders() {
        return productConverter.getProductDtos(hangGliderDao.findAll());
    }

    @Transactional
    public ProductDto changeHangGlider(ProductDto productDto) {
        HangGlider hangGlider = (HangGlider) productConverter.getProduct(productDto);
        hangGlider.setGuild(guildService.addGuild(hangGlider.getGuild()));
        return productConverter.getProductDto(hangGliderDao.save(hangGlider));
    }

    public List<String> getTypesByCompanyId(int companyId) {
        return hangGliderDao.findTypesByCompanyId(companyId);
    }

    public List<String> getTypesByGuildId(int guildId) {
        return hangGliderDao.findTypesByGuildId(guildId);
    }

    public List<ProductDto> getProductsByDateIntervalAndCompany(int companyId,
                                                                long beginDate,
                                                                long endDate) {
        if (endDate == 0) {
            return productConverter
                    .getProductDtos(hangGliderDao.findByDateIntervalAndCompany(companyId,
                            new Date(beginDate), new Date(System.currentTimeMillis())));
        }
        return productConverter
                .getProductDtos(hangGliderDao
                        .findByDateIntervalAndCompany(companyId,
                                new Date(beginDate),
                                new Date(endDate)));
    }

    public List<ProductDto> getProductsByDateIntervalAndGuild(int guildId,
                                                              long beginDate,
                                                              long endDate) {
        if (endDate == 0) {
            return productConverter
                    .getProductDtos(hangGliderDao.findByDateIntervalAndGuild(guildId,
                            new Date(beginDate), new Date(System.currentTimeMillis())));
        }
        return productConverter
                .getProductDtos(hangGliderDao
                        .findByDateIntervalAndGuild(guildId,
                                new Date(beginDate),
                                new Date(endDate)));
    }

    public List<ProductDto> getProductsByDateIntervalAndSite(int siteId,
                                                             long beginDate,
                                                             long endDate) {
        if (endDate == 0) {
            return productConverter
                    .getProductDtos(hangGliderDao.findByDateIntervalAndSite(siteId,
                            new Date(beginDate), new Date(System.currentTimeMillis())));
        }
        return productConverter
                .getProductDtos(hangGliderDao
                        .findByDateIntervalAndSite(siteId,
                                new Date(beginDate),
                                new Date(endDate)));
    }

    public List<ProductDto> findNowBuildingByCompany(int companyId) {
        return productConverter.getProductDtos(
                hangGliderDao.findNowBuildingByCompany(companyId));
    }

    public List<ProductDto> findNowBuildingByGuild(int guildId) {
        return productConverter.getProductDtos(
                hangGliderDao.findNowBuildingByGuild(guildId));
    }

    public List<ProductDto> findNowBuildingBySite(int siteId) {
        return productConverter.getProductDtos(
                hangGliderDao.findNowBuildingBySite(siteId));
    }

    public List<ProductDto> findByDateIntervalAndRange(int rangeId,
                                                       long beginDate,
                                                       long endDate) {
        if (endDate == 0) {
            return productConverter
                    .getProductDtos(hangGliderDao.findByDateIntervalAndRange(rangeId,
                            new Date(beginDate), new Date(System.currentTimeMillis())));
        }
        return productConverter
                .getProductDtos(hangGliderDao
                        .findByDateIntervalAndRange(rangeId,
                                new Date(beginDate),
                                new Date(endDate)));
    }
}
