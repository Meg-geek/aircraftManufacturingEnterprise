package com.nsu.bd.aircraft.controller.product;

import com.nsu.bd.aircraft.api.GeneralResponse;
import com.nsu.bd.aircraft.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/aircraft/products")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController {
    private final ProductService productService;

    @DeleteMapping("/delete-by-id")
    public GeneralResponse<?> deleteById(@RequestParam("productId") int productId) {
        productService.deleteByProductId(productId);
        return GeneralResponse.ok();
    }
}
