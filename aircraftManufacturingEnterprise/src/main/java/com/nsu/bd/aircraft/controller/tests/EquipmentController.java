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
    public void deleteById(@RequestParam("equipmentId") int equipmentId) {
        equipmentService.deleteById(equipmentId);
    }

    @GetMapping("/get-all")
    public GeneralResponse<List<EquipmentDto>> getAllEquipment() {
        return new GeneralResponse<>(equipmentService.getllEquipment());
    }

    @PutMapping("/update-equipment")
    public GeneralResponse<?> updateEquipment(@RequestBody EquipmentDto equipmentDto) {
        return new GeneralResponse<>(equipmentService.updateEquipment(equipmentDto));
    }
}
