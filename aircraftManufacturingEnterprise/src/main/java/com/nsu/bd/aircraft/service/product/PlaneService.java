package com.nsu.bd.aircraft.service.product;

import com.nsu.bd.aircraft.api.dto.product.ProductDto;
import com.nsu.bd.aircraft.dao.product.PlaneDao;
import com.nsu.bd.aircraft.service.converters.product.ProductConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PlaneService {
    private final PlaneDao planeDao;
    private final ProductConverter productConverter;

    public List<ProductDto> getAllPlanes() {
        return productConverter.getProductDtos(planeDao.findAll());
    }
}
