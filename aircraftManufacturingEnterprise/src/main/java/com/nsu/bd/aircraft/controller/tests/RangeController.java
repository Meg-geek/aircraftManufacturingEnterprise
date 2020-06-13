package com.nsu.bd.aircraft.controller.tests;

import com.nsu.bd.aircraft.api.GeneralResponse;
import com.nsu.bd.aircraft.api.dto.tests.RangeDto;
import com.nsu.bd.aircraft.service.tests.RangeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/aircraft/tests/range")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RangeController {
    private final RangeService rangeService;

    @GetMapping("/get-all")
    public GeneralResponse<List<RangeDto>> getAllRanges() {
        return new GeneralResponse<>(rangeService.getAllRanges());
    }

    @PostMapping("/add")
    public GeneralResponse<RangeDto> addRange(@RequestBody RangeDto rangeDto) {
        return new GeneralResponse<>(rangeService.addRange(rangeDto));
    }

    @DeleteMapping("/delete-by-id")
    public GeneralResponse<?> deleteById(@RequestParam("id") int rangeId) {
        rangeService.deleteById(rangeId);
        return GeneralResponse.ok();
    }

    @PutMapping("/update")
    public GeneralResponse<RangeDto> updateRange(@RequestBody RangeDto rangeDto) {
        return new GeneralResponse<>(rangeService.updateRange(rangeDto));
    }

    @GetMapping("/get-by-product-id")
    public GeneralResponse<List<RangeDto>> getByProductId(
            @RequestParam("productId") int productId) {
        return new GeneralResponse<>(rangeService.getByProductId(productId));
    }
}
