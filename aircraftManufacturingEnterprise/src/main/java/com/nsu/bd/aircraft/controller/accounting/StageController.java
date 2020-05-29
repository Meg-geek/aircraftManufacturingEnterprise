package com.nsu.bd.aircraft.controller.accounting;

import com.nsu.bd.aircraft.api.GeneralResponse;
import com.nsu.bd.aircraft.api.dto.accounting.StageDto;
import com.nsu.bd.aircraft.service.accounting.StageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/aircraft/accounting/stages")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StageController {
    private final StageService stageService;

    @GetMapping("/get-all")
    public GeneralResponse<List<StageDto>> getAll() {
        return new GeneralResponse<>(stageService.getAll());
    }

    @PostMapping("/add")
    public GeneralResponse<?> add(@RequestBody StageDto stageDto) {
        log.info("StageController:: Get request to add stage");
        stageService.add(stageDto);
        return GeneralResponse.ok();
    }

    @DeleteMapping("/delete-by-id")
    public GeneralResponse<?> deleteById(int id) {
        stageService.deleteById(id);
        return GeneralResponse.ok();
    }

    @PutMapping("/update")
    public GeneralResponse<StageDto> update(@RequestBody StageDto stageDto) {
        return new GeneralResponse<>(stageService.update(stageDto));
    }
}
