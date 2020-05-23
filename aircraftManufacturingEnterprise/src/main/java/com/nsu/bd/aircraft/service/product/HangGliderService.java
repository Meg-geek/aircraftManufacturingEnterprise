package com.nsu.bd.aircraft.service.product;

import com.nsu.bd.aircraft.api.dto.product.ProductDto;
import com.nsu.bd.aircraft.dao.product.HangGliderDao;
import com.nsu.bd.aircraft.service.converters.product.ProductConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HangGliderService {
    private final HangGliderDao hangGliderDao;
    private final ProductConverter productConverter;

    public List<ProductDto> getAllHangGliders() {
        return productConverter.getProductDtos(hangGliderDao.findAll());
    }
}
