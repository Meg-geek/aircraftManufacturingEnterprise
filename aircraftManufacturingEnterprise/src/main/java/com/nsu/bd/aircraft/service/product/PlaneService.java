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
        Plane plane = (Plane) productConverter.getProduct(productDto);
        plane.setGuild(guildService.addGuild(plane.getGuild()));
        return productConverter.getProductDto(planeDao.save(plane));
    }

    public List<String> getTypesByCompanyId(int companyId) {
        return planeDao.findTypesByCompanyId(companyId);
    }

    public List<String> getTypesByGuildId(int guildId) {
        return planeDao.findTypesByGuildId(guildId);
    }
}
