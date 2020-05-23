package com.nsu.bd.aircraft.controller.product;

import com.nsu.bd.aircraft.api.GeneralResponse;
import com.nsu.bd.aircraft.api.dto.product.ProductDto;
import com.nsu.bd.aircraft.service.product.HelicopterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/aircraft/products/helicopter")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HelicopterController {
    private final HelicopterService helicopterService;

    @GetMapping("/get-all")
    public GeneralResponse<List<ProductDto>> getAllHelicopters() {
        log.info("Get all helicopters request");
        return new GeneralResponse<>(helicopterService.getAllHelicopters());
    }

    @PutMapping("/change")
    public GeneralResponse<ProductDto> changeHelicopter(@RequestBody ProductDto changedHelicopter) {
        return new GeneralResponse<>(helicopterService.changeHelicopter(changedHelicopter));
    }

    @GetMapping("/get-types-by-company-id")
    public GeneralResponse<List<String>> getTypesByCompanyId(@RequestParam("companyId")
                                                                     int companyId) {
        return new GeneralResponse<>(helicopterService.getTypesByCompanyId(companyId));
    }

    @GetMapping("/get-types-by-guild-id")
    public GeneralResponse<List<String>> getTypesByGuildId(@RequestParam("guildId")
                                                                   int guildId) {
        return new GeneralResponse<>(helicopterService.getTypesByGuildId(guildId));
    }
}
