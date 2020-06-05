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

    @GetMapping("/get-by-date-interval-and-company")
    public GeneralResponse<List<ProductDto>> getProductsByDateIntervalAndCompany(
            @RequestParam("companyId") int companyId,
            @RequestParam("beginDate") long beginDate,
            @RequestParam("endDate") long endDate) {
        return new GeneralResponse<>(hangGliderService
                .getProductsByDateIntervalAndCompany(companyId, beginDate, endDate));
    }

    @GetMapping("/get-by-date-interval-and-guild")
    public GeneralResponse<List<ProductDto>> getProductsByDateIntervalAndGuild(
            @RequestParam("guildId") int guildId,
            @RequestParam("beginDate") long beginDate,
            @RequestParam("endDate") long endDate) {
        return new GeneralResponse<>(hangGliderService
                .getProductsByDateIntervalAndGuild(guildId, beginDate, endDate));
    }

    @GetMapping("/get-by-date-interval-and-site")
    public GeneralResponse<List<ProductDto>> getProductsByDateIntervalAndSite(
            @RequestParam("siteId") int siteId,
            @RequestParam("beginDate") long beginDate,
            @RequestParam("endDate") long endDate) {
        return new GeneralResponse<>(hangGliderService
                .getProductsByDateIntervalAndSite(siteId, beginDate, endDate));
    }

    @GetMapping("/get-now-building-by-company")
    public GeneralResponse<List<ProductDto>> findNowBuildingByCompany(
            @RequestParam("id") int id) {
        return new GeneralResponse<>(hangGliderService
                .findNowBuildingByCompany(id));
    }

    @GetMapping("/get-now-building-by-guild")
    public GeneralResponse<List<ProductDto>> findNowBuildingByGuild(
            @RequestParam("id") int id) {
        return new GeneralResponse<>(hangGliderService
                .findNowBuildingByGuild(id));
    }

    @GetMapping("/get-now-building-by-site")
    public GeneralResponse<List<ProductDto>> findNowBuildingBySite(
            @RequestParam("id") int id) {
        return new GeneralResponse<>(hangGliderService
                .findNowBuildingBySite(id));
    }

    @GetMapping("/get-by-date-interval-and-range")
    public GeneralResponse<List<ProductDto>> findByDateIntervalAndRange(
            @RequestParam("rangeId") int rangeId,
            @RequestParam("beginDate") long beginDate,
            @RequestParam("endDate") long endDate) {
        return new GeneralResponse<>(hangGliderService
                .findByDateIntervalAndRange(rangeId, beginDate, endDate));
    }
}
