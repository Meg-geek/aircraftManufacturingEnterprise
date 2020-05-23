package com.nsu.bd.aircraft.controller.product;

import com.nsu.bd.aircraft.api.GeneralResponse;
import com.nsu.bd.aircraft.api.dto.product.ProductDto;
import com.nsu.bd.aircraft.service.product.PlaneService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/aircraft/products/plane")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PlaneController {
    private final PlaneService planeService;

    @GetMapping("/get-all")
    public GeneralResponse<List<ProductDto>> getAllPlanes() {
        log.info("Get all planes request");
        return new GeneralResponse<>(planeService.getAllPlanes());
    }
}
