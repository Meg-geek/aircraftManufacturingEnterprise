package com.nsu.bd.aircraft.controller.tests;

import com.nsu.bd.aircraft.api.GeneralResponse;
import com.nsu.bd.aircraft.api.dto.tests.EquipmentDto;
import com.nsu.bd.aircraft.service.tests.EquipmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/aircraft/tests/equipment")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EquipmentController {
    private final EquipmentService equipmentService;

    @PostMapping("/add")
    public GeneralResponse<?> addEquipment(@RequestBody EquipmentDto equipmentDto) {
        equipmentService.addEquipment(equipmentDto);
        return GeneralResponse.ok();
    }

    @DeleteMapping("/delete-by-id")
    public GeneralResponse<?> deleteById(@RequestParam("equipmentId") int equipmentId) {
        equipmentService.deleteById(equipmentId);
        return GeneralResponse.ok();
    }

    @GetMapping("/get-all")
    public GeneralResponse<List<EquipmentDto>> getAllEquipment() {
        return new GeneralResponse<>(equipmentService.getllEquipment());
    }

    @PutMapping("/update")
    public GeneralResponse<?> updateEquipment(@RequestBody EquipmentDto equipmentDto) {
        return new GeneralResponse<>(equipmentService.updateEquipment(equipmentDto));
    }

    @GetMapping("/get-by-date-interval-and-product-and-range")
    public GeneralResponse<List<EquipmentDto>> getByProductAndRangeAndDateInterval(
            @RequestParam("productId") int productId,
            @RequestParam("rangeId") int rangeId,
            @RequestParam("beginDate") long beginDate,
            @RequestParam("endDate") long endDate) {
        return new GeneralResponse<>(equipmentService
                .getByProductAndRangeAndDateInterval(productId, rangeId, beginDate, endDate));
    }

    @GetMapping("/get-by-date-interval-and-range-and-hang-glider")
    public GeneralResponse<List<EquipmentDto>> getByRangeAndDateIntervalAndHangGlider(
            @RequestParam("rangeId") int rangeId,
            @RequestParam("beginDate") long beginDate,
            @RequestParam("endDate") long endDate) {
        return new GeneralResponse<>(equipmentService
                .getByRangeAndDateIntervalAndHangGlider(rangeId, beginDate, endDate));
    }

    @GetMapping("/get-by-date-interval-and-range-and-helicopter")
    public GeneralResponse<List<EquipmentDto>> getByRangeAndDateIntervalAndHelicopter(
            @RequestParam("rangeId") int rangeId,
            @RequestParam("beginDate") long beginDate,
            @RequestParam("endDate") long endDate) {
        return new GeneralResponse<>(equipmentService
                .getByRangeAndDateIntervalAndHelicopter(rangeId, beginDate, endDate));
    }

    @GetMapping("/get-by-date-interval-and-range-and-plane")
    public GeneralResponse<List<EquipmentDto>> getByRangeAndDateIntervalAndPlane(
            @RequestParam("rangeId") int rangeId,
            @RequestParam("beginDate") long beginDate,
            @RequestParam("endDate") long endDate) {
        log.info("get request to get equipment by date, range and plane");
        return new GeneralResponse<>(equipmentService
                .getByRangeAndDateIntervalAndPlane(rangeId, beginDate, endDate));
    }

    @GetMapping("/get-by-date-interval-and-range-and-rocket")
    public GeneralResponse<List<EquipmentDto>> getByRangeAndDateIntervalAndRocket(
            @RequestParam("rangeId") int rangeId,
            @RequestParam("beginDate") long beginDate,
            @RequestParam("endDate") long endDate) {
        return new GeneralResponse<>(equipmentService
                .getByRangeAndDateIntervalAndRocket(rangeId, beginDate, endDate));
    }

    @GetMapping("/get-by-date-interval-and-range")
    public GeneralResponse<List<EquipmentDto>> getByRangeAndDateInterval(
            @RequestParam("rangeId") int rangeId,
            @RequestParam("beginDate") long beginDate,
            @RequestParam("endDate") long endDate) {
        return new GeneralResponse<>(equipmentService
                .getByRangeAndDateInterval(rangeId, beginDate, endDate));
    }
}
