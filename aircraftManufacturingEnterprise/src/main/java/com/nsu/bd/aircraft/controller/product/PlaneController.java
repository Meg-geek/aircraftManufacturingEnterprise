package com.nsu.bd.aircraft.controller.product;

import com.nsu.bd.aircraft.api.GeneralResponse;
import com.nsu.bd.aircraft.api.dto.product.ProductDto;
import com.nsu.bd.aircraft.service.product.PlaneService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/aircraft/products/plane")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PlaneController {
    private final PlaneService planeService;

    @PostMapping("/add")
    public GeneralResponse<?> add(@RequestBody ProductDto productDto) {
        planeService.add(productDto);
        return GeneralResponse.ok();
    }

    @GetMapping("/get-all")
    public GeneralResponse<List<ProductDto>> getAllPlanes() {
        log.info("Get all planes request");
        return new GeneralResponse<>(planeService.getAllPlanes());
    }

    @PutMapping("/update")
    public GeneralResponse<ProductDto> changePlane(@RequestBody ProductDto changedPlane) {
        return new GeneralResponse<>(planeService.changePlane(changedPlane));
    }

    @GetMapping("/get-types-by-company-id")
    public GeneralResponse<List<String>> getTypesByCompanyId(@RequestParam("companyId")
                                                                     int companyId) {
        return new GeneralResponse<>(planeService.getTypesByCompanyId(companyId));
    }

    @GetMapping("/get-types-by-guild-id")
    public GeneralResponse<List<String>> getTypesByGuildId(@RequestParam("guildId")
                                                                   int guildId) {
        return new GeneralResponse<>(planeService.getTypesByGuildId(guildId));
    }

    @GetMapping("/get-by-date-interval-and-company")
    public GeneralResponse<List<ProductDto>> getProductsByDateIntervalAndCompany(
            @RequestParam("companyId") int companyId,
            @RequestParam("beginDate") long beginDate,
            @RequestParam("endDate") long endDate) {
        return new GeneralResponse<>(planeService
                .getProductsByDateIntervalAndCompany(companyId, beginDate, endDate));
    }

    @GetMapping("/get-by-date-interval-and-guild")
    public GeneralResponse<List<ProductDto>> getProductsByDateIntervalAndGuild(
            @RequestParam("guildId") int guildId,
            @RequestParam("beginDate") long beginDate,
            @RequestParam("endDate") long endDate) {
        return new GeneralResponse<>(planeService
                .getProductsByDateIntervalAndGuild(guildId, beginDate, endDate));
    }

    @GetMapping("/get-by-date-interval-and-site")
    public GeneralResponse<List<ProductDto>> getProductsByDateIntervalAndSite(
            @RequestParam("siteId") int siteId,
            @RequestParam("beginDate") long beginDate,
            @RequestParam("endDate") long endDate) {
        return new GeneralResponse<>(planeService
                .getProductsByDateIntervalAndSite(siteId, beginDate, endDate));
    }

    @GetMapping("/get-now-building-by-company")
    public GeneralResponse<List<ProductDto>> findNowBuildingByCompany(
            @RequestParam("id") int id) {
        log.info("Get request to get now building planes by company");
        return new GeneralResponse<>(planeService
                .findNowBuildingByCompany(id));
    }

    @GetMapping("/get-now-building-by-guild")
    public GeneralResponse<List<ProductDto>> findNowBuildingByGuild(
            @RequestParam("id") int id) {
        log.info("Get request to get now building planes by guild");
        return new GeneralResponse<>(planeService
                .findNowBuildingByGuild(id));
    }

    @GetMapping("/get-now-building-by-site")
    public GeneralResponse<List<ProductDto>> findNowBuildingBySite(
            @RequestParam("id") int id) {
        log.info("Get request to get now building planes by site");
        return new GeneralResponse<>(planeService
                .findNowBuildingBySite(id));
    }

    @GetMapping("/get-by-date-interval-and-range")
    public GeneralResponse<List<ProductDto>> findByDateIntervalAndRange(
            @RequestParam("rangeId") int rangeId,
            @RequestParam("beginDate") long beginDate,
            @RequestParam("endDate") long endDate) {
        log.info("Get request to get planes by date and range");
        return new GeneralResponse<>(planeService
                .findByDateIntervalAndRange(rangeId, beginDate, endDate));
    }
}
