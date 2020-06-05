package com.nsu.bd.aircraft.controller.staff;

import com.nsu.bd.aircraft.api.GeneralResponse;
import com.nsu.bd.aircraft.api.dto.staff.EmployeeDto;
import com.nsu.bd.aircraft.service.staff.TesterService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/aircraft/staff/testers")
public class TesterController extends StaffController {
    private final TesterService testerService;

    public TesterController(@Autowired TesterService testerService) {
        super(testerService);
        this.testerService = testerService;
    }

    @GetMapping("get-by-date-interval-and-product-and-range")
    public GeneralResponse<List<EmployeeDto>> getByProductAndRangeAndDateInterval(
            @RequestParam("productId") int productId,
            @RequestParam("rangeId") int rangeId,
            @RequestParam("beginDate") long beginDate,
            @RequestParam("endDate") long endDate) {
        return new GeneralResponse<>(testerService
                .getByProductAndRangeAndDateInterval(productId, rangeId, beginDate, endDate));
    }

    @GetMapping("/get-by-date-interval-and-range-and-hang-glider")
    public GeneralResponse<List<EmployeeDto>> getByRangeAndDateIntervalAndHangGlider(
            @RequestParam("rangeId") int rangeId,
            @RequestParam("beginDate") long beginDate,
            @RequestParam("endDate") long endDate) {
        return new GeneralResponse<>(testerService
                .getByRangeAndDateIntervalAndHangGlider(rangeId, beginDate, endDate));
    }

    @GetMapping("/get-by-date-interval-and-range-and-helicopter")
    public GeneralResponse<List<EmployeeDto>> getByRangeAndDateIntervalAndHelicopter(
            @RequestParam("rangeId") int rangeId,
            @RequestParam("beginDate") long beginDate,
            @RequestParam("endDate") long endDate) {
        return new GeneralResponse<>(testerService
                .getByRangeAndDateIntervalAndHelicopter(rangeId, beginDate, endDate));
    }

    @GetMapping("/get-by-date-interval-and-range-and-plane")
    public GeneralResponse<List<EmployeeDto>> getByRangeAndDateIntervalAndPlane(
            @RequestParam("rangeId") int rangeId,
            @RequestParam("beginDate") long beginDate,
            @RequestParam("endDate") long endDate) {
        return new GeneralResponse<>(testerService
                .getByRangeAndDateIntervalAndPlane(rangeId, beginDate, endDate));
    }

    @GetMapping("/get-by-date-interval-and-range-and-rocket")
    public GeneralResponse<List<EmployeeDto>> getByRangeAndDateIntervalAndRocket(
            @RequestParam("rangeId") int rangeId,
            @RequestParam("beginDate") long beginDate,
            @RequestParam("endDate") long endDate) {
        return new GeneralResponse<>(testerService
                .getByRangeAndDateIntervalAndRocket(rangeId, beginDate, endDate));
    }

    @GetMapping("/get-by-date-interval-and-range")
    public GeneralResponse<List<EmployeeDto>> getByRangeAndDateInterval(
            @RequestParam("rangeId") int rangeId,
            @RequestParam("beginDate") long beginDate,
            @RequestParam("endDate") long endDate) {
        return new GeneralResponse<>(testerService
                .getByRangeAndDateInterval(rangeId, beginDate, endDate));
    }
}
