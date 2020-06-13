package com.nsu.bd.aircraft.service.accounting;

import com.nsu.bd.aircraft.api.dto.accounting.ProductAccountingDto;
import com.nsu.bd.aircraft.dao.accounting.ProductAccountingDao;
import com.nsu.bd.aircraft.model.accounting.ProductAccounting;
import com.nsu.bd.aircraft.service.company.SiteService;
import com.nsu.bd.aircraft.service.converters.accounting.ProductAccountingConverter;
import com.nsu.bd.aircraft.service.product.ProductService;
import com.nsu.bd.aircraft.service.tests.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductAccountingService {
    private final ProductAccountingDao productAccountingDao;
    private final ProductAccountingConverter converter;
    private final ProductService productService;
    private final StageService stageService;
    private final SiteService siteService;
    private final TestService testService;

    public List<ProductAccountingDto> getAll() {
        return converter.getProductAccountingDtos(productAccountingDao.findAll());
    }

    @Transactional
    public void add(ProductAccountingDto accountingDto) {
        productAccountingDao.save(converter.getProductAccounting(accountingDto));
    }

    public void deleteById(int id) {
        productAccountingDao.deleteById(id);
    }

    @Transactional
    public ProductAccountingDto update(ProductAccountingDto accountingDto) {
        ProductAccounting productAccounting = converter
                .getProductAccounting(accountingDto);
        productAccounting
                .setProduct(productService.findById(productAccounting.getProduct().getId()));
        productAccounting
                .setStage(stageService.addStage(productAccounting.getStage()));
        productAccounting
                .setSite(siteService.addSite(productAccounting.getSite()));
        productAccounting
                .setTest(testService.addTest(productAccounting.getTest()));
        ProductAccounting updated = productAccountingDao
                .save(productAccounting);
        return converter
                .getProductAccountingDto(updated);
    }

    public List<String> getProductWorkTypesByProductId(int productId) {
        return productAccountingDao.getProductWorkTypesByProductId(productId);
    }
}
