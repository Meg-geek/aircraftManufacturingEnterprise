package com.nsu.bd.aircraft.service.converters.accounting;


import com.nsu.bd.aircraft.api.dto.accounting.ProductAccountingDto;
import com.nsu.bd.aircraft.model.accounting.ProductAccounting;
import com.nsu.bd.aircraft.service.converters.company.SiteConverter;
import com.nsu.bd.aircraft.service.converters.product.ProductConverter;
import com.nsu.bd.aircraft.service.converters.tests.TestConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductAccountingConverter {
    private final ProductConverter productConverter;
    private final SiteConverter siteConverter;
    private final StageConverter stageConverter;
    private final TestConverter testConverter;

    public ProductAccounting getProductAccounting(ProductAccountingDto productAccountingDto) {
        if (productAccountingDto == null) {
            return null;
        }
        ProductAccounting productAccounting = new ProductAccounting();
        productAccounting.setProduct(productConverter
                .getProduct(productAccountingDto.getProduct()));
        productAccounting.setSite(siteConverter
                .getSite(productAccountingDto.getSite()));
        productAccounting.setStage(stageConverter
                .getStage(productAccountingDto.getStage()));
        productAccounting.setTest(testConverter
                .getTest(productAccountingDto.getTest()));
        if (productAccountingDto.getBeginTime() != 0) {
            productAccounting.setBeginTime(new Date(productAccountingDto.getBeginTime()));
        }
        if (productAccountingDto.getEndTime() != 0) {
            productAccounting.setEndTime(new Date(productAccountingDto.getEndTime()));
        }
        return productAccounting;
    }

    public ProductAccountingDto getProductAccountingDto(ProductAccounting productAccounting) {
        if (productAccounting == null) {
            return null;
        }
        ProductAccountingDto productAccountingDto = new ProductAccountingDto();
        productAccountingDto.setProduct(productConverter
                .getProductDto(productAccounting.getProduct()));
        productAccountingDto.setSite(siteConverter
                .getSiteDto(productAccounting.getSite()));
        productAccountingDto.setStage(stageConverter
                .getStageDto(productAccounting.getStage()));
        productAccountingDto.setTest(testConverter
                .getTestDto(productAccounting.getTest()));
        if (productAccounting.getBeginTime() != null) {
            productAccountingDto.setBeginTime(productAccounting.getBeginTime().getTime());
        }
        if (productAccounting.getEndTime() != null) {
            productAccountingDto.setEndTime(productAccounting.getEndTime().getTime());
        }
        return productAccountingDto;
    }

    public List<ProductAccountingDto> getProductAccountingDtos(
            List<ProductAccounting> accountingList) {
        if (accountingList == null) {
            return Collections.emptyList();
        }
        return accountingList.stream()
                .map(this::getProductAccountingDto).collect(Collectors.toList());
    }
}
