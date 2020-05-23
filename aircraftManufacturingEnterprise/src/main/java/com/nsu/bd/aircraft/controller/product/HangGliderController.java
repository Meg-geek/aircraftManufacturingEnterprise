package com.nsu.bd.aircraft.controller.product;

import com.nsu.bd.aircraft.api.GeneralResponse;
import com.nsu.bd.aircraft.api.dto.product.ProductDto;
import com.nsu.bd.aircraft.service.product.HangGliderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/aircraft/products/hang-glider")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HangGliderController {
    private final HangGliderService hangGliderService;

    @GetMapping("/get-all")
    public GeneralResponse<List<ProductDto>> getAllHangGliders() {
        log.info("Get all hang gliders request");
        return new GeneralResponse<>(hangGliderService.getAllHangGliders());
    }
}
