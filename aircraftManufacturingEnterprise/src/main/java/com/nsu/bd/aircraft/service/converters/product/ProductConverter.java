package com.nsu.bd.aircraft.service.converters.product;

import com.nsu.bd.aircraft.api.dto.product.ProductDto;
import com.nsu.bd.aircraft.model.product.*;
import com.nsu.bd.aircraft.service.converters.company.GuildConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductConverter {
    private static final int MIN_CHARGE_POWER = 0;
    private static final int MIN_ENGINE_AMOUNT = 0;
    private static final int MIN_WEIGHT = 0;
    private final GuildConverter guildConverter;

    public Product getProduct(ProductDto productDto) {
        if (productDto.getChargePower() > MIN_CHARGE_POWER) {
            return createRocket(productDto);
        }
        if (productDto.getEngineAmount() > MIN_ENGINE_AMOUNT) {
            return createPlane(productDto);
        }
        if (productDto.getWeight() > MIN_WEIGHT) {
            return createHelicopter(productDto);
        }
        return createHangGlider(productDto);
    }

    public ProductDto getProductDto(Product product) {
        ProductDto productDto = new ProductDto(product.getId(),
                guildConverter.getGuildDto(product.getGuild()));
        if (product instanceof HangGlider) {
            productDto.setType(((HangGlider) product).getType());
        }
        if (product instanceof Helicopter) {
            productDto.setType(((Helicopter) product).getType());
        }
        if (product instanceof Plane) {
            Plane plane = (Plane) product;
            productDto.setType(plane.getType());
            productDto.setEngineAmount(plane.getEngineAmount());
        }
        if (product instanceof Rocket) {
            Rocket rocket = (Rocket) product;
            productDto.setChargePower(rocket.getChargePower());
            productDto.setType(rocket.getType());
        }
        return productDto;
    }

    public List<ProductDto> getProductDtos(List<? extends Product> products) {
        if (products == null) {
            return emptyList();
        }
        return products.stream()
                .map(this::getProductDto).collect(toList());
    }

    public List<Product> getProducts(List<ProductDto> productDtos) {
        if (productDtos == null) {
            return emptyList();
        }
        return productDtos.stream()
                .map(this::getProduct).collect(toList());
    }

    private HangGlider createHangGlider(ProductDto productDto) {
        HangGlider hangGlider = new HangGlider();
        setIdAndGuild(hangGlider, productDto);
        hangGlider.setType(productDto.getType());
        return hangGlider;
    }

    private Helicopter createHelicopter(ProductDto productDto) {
        Helicopter helicopter = new Helicopter();
        setIdAndGuild(helicopter, productDto);
        helicopter.setType(productDto.getType());
        helicopter.setWeight(productDto.getWeight());
        return helicopter;
    }

    private Plane createPlane(ProductDto productDto) {
        Plane plane = new Plane();
        setIdAndGuild(plane, productDto);
        plane.setType(productDto.getType());
        plane.setEngineAmount(productDto.getEngineAmount());
        return plane;
    }

    private void setIdAndGuild(Product product, ProductDto productDto) {
        product.setId(productDto.getId());
        product.setGuild(guildConverter.getGuild(productDto.getGuild()));
    }

    private Rocket createRocket(ProductDto productDto) {
        Rocket rocket = new Rocket();
        setIdAndGuild(rocket, productDto);
        rocket.setChargePower(productDto.getChargePower());
        rocket.setType(productDto.getType());
        return rocket;
    }
}
