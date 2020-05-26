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
    public GeneralResponse<?> addRange(@RequestBody RangeDto rangeDto) {
        rangeService.addRange(rangeDto);
        return GeneralResponse.ok();
    }

    @DeleteMapping("/delete-by-id")
    public void deleteById(@RequestParam("rangeId") int rangeId) {
        rangeService.deleteById(rangeId);
    }

    @PutMapping("/update")
    public GeneralResponse<RangeDto> updateRange(@RequestBody RangeDto rangeDto) {
        return new GeneralResponse<>(rangeService.updateRange(rangeDto));
    }
}
