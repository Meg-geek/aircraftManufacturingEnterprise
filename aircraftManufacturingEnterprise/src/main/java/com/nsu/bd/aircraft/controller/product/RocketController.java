package com.nsu.bd.aircraft.controller.product;

import com.nsu.bd.aircraft.api.ErrorCause;
import com.nsu.bd.aircraft.api.GeneralResponse;
import com.nsu.bd.aircraft.api.Status;
import com.nsu.bd.aircraft.api.dto.product.ProductDto;
import com.nsu.bd.aircraft.service.product.RocketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/aircraft/products/rocket")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RocketController {
    private final RocketService rocketService;

    @GetMapping("/get-all")
    public GeneralResponse<List<ProductDto>> getAllRockets() {
        log.info("Get all rockets request");
        return new GeneralResponse<>(rocketService.getAllRockets());
    }

    @PostMapping("/add")
    public GeneralResponse<?> addProduct(@RequestBody ProductDto productDto) {
        if (rocketService.addRocket(productDto)) {
            return GeneralResponse.ok();
        }
        return new GeneralResponse<>(Status.ERROR, ErrorCause.WRONG_FORMAT);
    }

    @PutMapping("/change")
    public GeneralResponse<ProductDto> changeRocket(@RequestBody ProductDto changedRocket) {
        return new GeneralResponse<>(rocketService.changeRocket(changedRocket));
    }

    @GetMapping("/get-types-by-company-id")
    public GeneralResponse<List<String>> getTypesByCompanyId(@RequestParam("companyId")
                                                                     int companyId) {
        return new GeneralResponse<>(rocketService.getTypesByCompanyId(companyId));
    }

    @GetMapping("/get-types-by-guild-id")
    public GeneralResponse<List<String>> getTypesByGuildId(@RequestParam("guildId")
                                                                   int guildId) {
        return new GeneralResponse<>(rocketService.getTypesByGuildId(guildId));
    }
}
