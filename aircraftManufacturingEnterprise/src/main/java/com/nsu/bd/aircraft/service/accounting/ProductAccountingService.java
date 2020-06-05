package com.nsu.bd.aircraft.service.accounting;

import com.nsu.bd.aircraft.api.dto.accounting.ProductAccountingDto;
import com.nsu.bd.aircraft.dao.accounting.ProductAccountingDao;
import com.nsu.bd.aircraft.service.converters.accounting.ProductAccountingConverter;
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
        return converter
                .getProductAccountingDto(productAccountingDao
                        .save(converter
                                .getProductAccounting(accountingDto)));
    }

    public List<String> getProductWorkTypesByProductId(int productId) {
        return productAccountingDao.getProductWorkTypesByProductId(productId);
    }
}
