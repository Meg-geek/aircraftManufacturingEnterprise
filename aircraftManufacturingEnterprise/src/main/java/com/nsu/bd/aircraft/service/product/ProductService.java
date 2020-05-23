package com.nsu.bd.aircraft.service.product;

import com.nsu.bd.aircraft.dao.product.ProductDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {
    private final ProductDao productDao;

    @Transactional
    public void deleteByProductId(int productId) {
        productDao.deleteById(productId);
    }
}
