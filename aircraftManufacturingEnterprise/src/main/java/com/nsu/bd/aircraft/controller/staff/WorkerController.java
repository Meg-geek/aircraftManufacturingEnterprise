package com.nsu.bd.aircraft.controller.staff;

import com.nsu.bd.aircraft.api.GeneralResponse;
import com.nsu.bd.aircraft.api.dto.staff.BrigadeDto;
import com.nsu.bd.aircraft.api.dto.staff.EmployeeDto;
import com.nsu.bd.aircraft.service.staff.WorkerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/aircraft/staff/workers")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WorkerController {
    private final WorkerService workerService;

    @PostMapping("/get-by-brigade")
    public GeneralResponse<List<EmployeeDto>> getByBrigade(
            @RequestBody BrigadeDto brigade) {
        return new GeneralResponse<>(workerService.getByBrigade(brigade));
    }

    @PutMapping("/set-brigade")
    public GeneralResponse setWorkerBrigade(
            @RequestParam("workerId") int workerId,
            @RequestParam("brigadeId") int brigadeId) {
        workerService.setWorkerBrigade(workerId, brigadeId);
        return GeneralResponse.ok();
    }
}
