package com.nsu.bd.aircraft.controller.product;

import com.nsu.bd.aircraft.api.GeneralResponse;
import com.nsu.bd.aircraft.api.dto.product.ProductDto;
import com.nsu.bd.aircraft.service.product.HangGliderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/change")
    public GeneralResponse<ProductDto> changePlane(@RequestBody ProductDto changedHangGlider) {
        return new GeneralResponse<>(hangGliderService.changeHangGlider(changedHangGlider));
    }

    @GetMapping("/get-types-by-company-id")
    public GeneralResponse<List<String>> getTypesByCompanyId(@RequestParam("companyId")
                                                                     int companyId) {
        return new GeneralResponse<>(hangGliderService.getTypesByCompanyId(companyId));
    }

    @GetMapping("/get-types-by-guild-id")
    public GeneralResponse<List<String>> getTypesByGuildId(@RequestParam("guildId")
                                                                   int guildId) {
        return new GeneralResponse<>(hangGliderService.getTypesByGuildId(guildId));
    }
}
