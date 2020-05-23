package com.nsu.bd.aircraft.service.product;

import com.nsu.bd.aircraft.api.dto.product.ProductDto;
import com.nsu.bd.aircraft.dao.product.RocketDao;
import com.nsu.bd.aircraft.model.product.Product;
import com.nsu.bd.aircraft.model.product.Rocket;
import com.nsu.bd.aircraft.service.company.GuildService;
import com.nsu.bd.aircraft.service.converters.product.ProductConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RocketService {
    private final RocketDao rocketDao;
    private final ProductConverter productConverter;
    private final GuildService guildService;

    public List<ProductDto> getAllRockets() {
        return productConverter.getProductDtos(rocketDao.findAll());
    }

    @Transactional
    public boolean addRocket(ProductDto productDto) {
        Product product = productConverter.getProduct(productDto);
        if (!(product instanceof Rocket)) {
            return false;
        }
        rocketDao.save((Rocket) product);
        return true;
    }

    @Transactional
    public ProductDto changeRocket(ProductDto productDto) {
        Rocket rocket = (Rocket) productConverter.getProduct(productDto);
        rocket.setGuild(guildService.addGuild(rocket.getGuild()));
        return productConverter.getProductDto(rocketDao.save(rocket));
    }

    public List<String> getTypesByCompanyId(int companyId) {
        return rocketDao.findTypesByCompanyId(companyId);
    }

    public List<String> getTypesByGuildId(int guildId) {
        return rocketDao.findTypesByGuildId(guildId);
    }
}
